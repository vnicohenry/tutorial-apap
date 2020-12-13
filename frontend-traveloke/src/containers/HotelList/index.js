import React , { Component } from "react" ;
import Hotel from "../../components/Hotel" ;
import classes from "./styles.module.css" ;
import APIConfig from "../../api/APIConfig";
import Button from "../../components/Button" ;
import Modal from "../../components/Modal" ;

class HotelList extends Component {
  constructor(props){
    super(props);
    this.state = {
      hotels: [],
      isLoading: false,
      isCreate: false,
      isEdit: false,
      namaHotel: "",
      alamat: "",
      nomorTelepon: "",
      search: "",
    };
    this.handleChangeField = this.handleChangeField.bind(this);
    this.handleAddHotel = this.handleAddHotel.bind(this);
    this.handleCancel = this.handleCancel.bind(this);
    this.handleSubmitAddHotel = this.handleSubmitAddHotel.bind(this);
    this.handleEditHotel = this.handleEditHotel.bind(this);
  }
  handleEditHotel(hotel){
    this.setState({
      isEdit: true,
      id: hotel.id,
      namaHotel: hotel.namaHotel,
      alamat: hotel.alamat,
      nomorTelepon: hotel.nomorTelepon,
    });
  }
  handleChangeField(event){
    const {name, value} = event.target;
    this.setState({ [name]:value });
  }
  updateSearch(event) {
    this.setState({search: event.target.value});
  }
  async handleSubmitAddHotel(event){
    event.preventDefault();
    try {
      const data = {
        namaHotel: this.state.namaHotel,
        alamat: this.state.alamat,
        nomorTelepon: this.state.nomorTelepon,
      };
      await APIConfig.post("/hotel", data);
      this.loadData();
    } catch (error){
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
    this.handleCancel(event);
    this.setState({
      namaHotel: "",
      alamat:"",
      nomorTelepon:"",
    })
  }
  async handleSubmitEditHotel(event){
    event.preventDefault();
    try{
      const data = {
        namaHotel: this.state.namaHotel,
        alamat: this.state.alamat,
        nomorTelepon: this.state.nomorTelepon,
      };
      await APIConfig.put(`/hotel/${this.state.id}`, data);
      this.loadData();
    } catch(error){
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
    this.handleCancel(event);
  }
  async handleDeleteHotel(id){
    try{
      await APIConfig.delete(`/hotel/${id}`);
      this.loadData();
    } catch(error){
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
  }
  handleAddHotel(){
    this.setState({ isCreate: true });
  }
  handleCancel(event){
    event.preventDefault();
    this.setState({ isCreate:false, isEdit:false });
  }
  componentDidMount() {
    this.loadData();
  }
  async loadData(){
    try{
      const { data } = await APIConfig.get("/hotels");
      this.setState({ hotels:data });
    } catch(error){
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
  }
  render() {
    let filteredHotel = this.state.hotels.filter(
      (hotel) => {
        var namaHotelList = hotel.namaHotel.toLowerCase().split(" ");
        console.log(namaHotelList);
        for(var i = 0; i < namaHotelList.length; i++){
          console.log(i);
          if (namaHotelList[i].startsWith(this.state.search.toLowerCase())){
            return hotel.namaHotel;
          }
        }
        return "";
      }
    );
    return (
      <div className={classes.hotelList}>
        <h1 className={classes.title}> All Hotels </h1>
        <Button onClick={this.handleAddHotel} variant="primary">
          Add Hotel
        </Button>
        <input
          type="text"
          className="form-control mt-3"
          placeholder="Search Hotel Name"
          value={this.state.search}
          onChange={this.updateSearch.bind(this)}
        />
        <div>
          {filteredHotel.map((hotel) => (
            <Hotel
            key={hotel.id}
            id={hotel.id}
            namaHotel={hotel.namaHotel}
            alamat={hotel.alamat}
            listKamar={hotel.listKamar}
            nomorTelepon={hotel.nomorTelepon}
            handleEdit={() => this.handleEditHotel(hotel)}
            handleDelete={() => this.handleDeleteHotel(hotel.id)}
            />
          ))}
        </div>
        <Modal
          show={this.state.isCreate || this.state.isEdit}
          handleCloseModal={this.handleCancel}
          >
          <form>
            <h3 className={classes.modalTitle}>
              {this.state.isCreate
              ? "Add Hotel"
              : `Edit Hotel Nomor ${this.state.id}`}
            </h3>
            <input
              className={classes.textField}
              type="text"
              placeholder="Nama Hotel"
              name="namaHotel"
              value={this.state.namaHotel}
              onChange={this.handleChangeField}
            />
            <input
              className={classes.textField}
              type="text"
              placeholder="Alamat"
              name="alamat"
              value={this.state.alamat}
              onChange={this.handleChangeField}
            />
            <textarea
              className={classes.textField}
              placeholder= "NomorTelepon"
              name="nomorTelepon"
              rows="4"
              value={this.state.nomorTelepon}
              onChange={this.handleChangeField}
            />
            <Button
              onClick={
                this.state.isCreate
                ? this.handleSubmitAddHotel
                : this.handleSubmitEditHotel
              }
              variant="primary"
            >
            {this.state.isCreate ? "Create" : "Edit"}
            </Button>
            <Button onClick={this.handleCancel} variant="danger">
              Cancel
            </Button>
          </form>
        </Modal>
      </div>
    );
  }
}

export default HotelList;

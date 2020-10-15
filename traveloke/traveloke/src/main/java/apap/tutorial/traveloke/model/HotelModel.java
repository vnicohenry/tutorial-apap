package apap.tutorial.traveloke.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="hotel")
public class HotelModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=30)
    @Column(name="namaHotel", nullable=false)
    private String namaHotel;

    @NotNull
    @Size(max=30)
    @Column(name="alamat", nullable=false)
    private String alamat;

    @NotNull
    @Column
    private Integer nomorTelepon;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KamarModel> listKamar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaHotel() {
        return namaHotel;
    }

    public void setNamaHotel(String namaHotel) {
        this.namaHotel = namaHotel;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Integer getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(Integer nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public List<KamarModel> getListKamar() {
        return listKamar;
    }

    public void setListKamar(List<KamarModel> listKamar) {
        this.listKamar = listKamar;
    }
}

//public class HotelModel {
//    private String idHotel;
//    private String namaHotel;
//    private String alamat;
//    private String noTelepon;
//
//    public HotelModel(String idHotel, String namaHotel, String alamat, String noTelepon) {
//        this.idHotel = idHotel;
//        this.namaHotel = namaHotel;
//        this.alamat = alamat;
//        this.noTelepon = noTelepon;
//    }
//
//    public String getIdHotel() {
//        return idHotel;
//    }
//
//    public String getNamaHotel() {
//        return namaHotel;
//    }
//
//    public String getAlamat() {
//        return alamat;
//    }
//
//    public String getNoTelepon() {
//        return noTelepon;
//    }
//
//    public void setIdHotel(String idHotel) {
//        this.idHotel = idHotel;
//    }
//
//    public void setNamaHotel(String namaHotel) {
//        this.namaHotel = namaHotel;
//    }
//
//    public void setAlamat(String alamat) {
//        this.alamat = alamat;
//    }
//
//    public void setNoTelepon(String noTelepon) {
//        this.noTelepon = noTelepon;
//    }
//}





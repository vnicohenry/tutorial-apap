import React from "react";
import classes from "./styles.module.css";

const KamarList = (props) => {
  const {listKamar} = props;
  return (
    <div className="container-fluid p-0 mb-4">
      {listKamar.map((kamar) =>(
        <span className={`${classes.kamar} badge bg-primary mr-5`}>{kamar.namaKamar} ({kamar.kapasitasKamar})</span>
      ))}
    </div>
  );
};

export default KamarList ;

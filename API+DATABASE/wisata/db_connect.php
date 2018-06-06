<?php

class DB_CONNECT{

	function __construct() {
        $this->connect();
    }

    function __destruct() {
        $this->close();
    }

 
    function connect() {
        require_once __DIR__ . '/db_config.php';

        $con = mysqli_connect(DB_SERVER, DB_USER, DB_PASSWORD) ;
        $db = mysqli_select_db( $con, DB_DATABASE);
        $con2=$con;
        return $con;
        
    }

    function close() {
  //      mysqli_close($con2);
    }
}

?>
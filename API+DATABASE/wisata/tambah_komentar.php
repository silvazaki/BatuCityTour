<?php

include "koneksi2.php";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
    echo '{"query_result":"ERROR"}';
} 

$wisata = $_GET['id_wisata'];
$user = $_GET['id_user'];
$komentar = $_GET['komentar'];

$sql = "insert into komentar value ('','$wisata','$user','$komentar')";

if ($conn->query($sql) == TRUE) {
    
    echo '{"query_result":"SUCCESS"}';

} else {
    echo '{"query_result":"FAILURE"}';
	echo $sql;
}
$conn->close();
?>
<?php

include "koneksi2.php";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
    echo '{"query_result":"ERROR"}';
} 

$user = $_GET['user'];
$pass = $_GET['pass'];

$sql = "insert into user value ('','$user','$pass')";

if ($conn->query($sql) == TRUE) {
    
    echo '{"query_result":"SUCCESS"}';

} else {
    echo '{"query_result":"FAILURE"}';
	echo $sql;
}
$conn->close();
?>
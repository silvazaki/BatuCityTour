<?php
include "koneksi2.php";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
    echo '{"query_result":"ERROR"}';
} else{
}
$user = $_GET['username'];
$pass = $_GET['pass'];


$sql = "select id_user from user where username='$user' and password='$pass'";

if ($conn->query($sql) == TRUE) {
    
	$res = $conn->query($sql);
	if ($res->num_rows > 0){
		if($row = $res->fetch_assoc()){
			echo '{"query_result":"'.$row['id_user'].'"}';
		}
	}else{
		echo '{"query_result":"KOSONG"}';
	}

} else {
    echo '{"query_result":"FAILURE"}';
	echo $sql;
}
$conn->close();
?>
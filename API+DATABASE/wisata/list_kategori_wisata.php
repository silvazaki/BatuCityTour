<?php
require_once __DIR__ . '/db_connect.php';
$response = array();
$db = new DB_CONNECT();

	mysqli_query($db->connect(), "SET NAMES utf8");
	$query = mysqli_query($db->connect(), "select * from kategori");
	$json = array();
	while($row = mysqli_fetch_assoc($query)){
		$json[]=$row;
	}

	echo json_encode(
		array('item' => $json), 
		JSON_FORCE_OBJECT
	);
?>
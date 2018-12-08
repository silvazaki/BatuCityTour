<?php
require_once __DIR__ . '/db_connect.php';
$response = array();
$db = new DB_CONNECT();

$kategori = $_GET['id_wisata'];

	mysqli_query($db->connect(), "SET NAMES utf8");
	$query = mysqli_query($db->connect(), "select id_komentar, user.username, komentar.id_wisata, komentar from komentar, user where id_wisata=$kategori and user.id_user=komentar.id_user");
	$json = array();
	while($row = mysqli_fetch_assoc($query)){
		$json[]=$row;
	}

	echo json_encode(
		array('item' => $json), 
		JSON_FORCE_OBJECT
	);
?>
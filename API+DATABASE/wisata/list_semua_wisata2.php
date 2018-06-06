<?php
require_once __DIR__ . '/db_connect.php';
$response = array();
$db = new DB_CONNECT();

$kategori = $_GET['id_kategori'];

	mysqli_query($db->connect(), "SET NAMES utf8");
	$query = mysqli_query($db->connect(), "select a.*, b.nama_kategori, c.jenis_kategori from wisata a, kategori b, kategori_harga c where a.id_kategori = b.id_kategori and a.id_kategori_harga = c.id_kategori_harga and a.id_kategori = '$kategori' order by id_wisata asc");
	$json = array();
	while($row = mysqli_fetch_assoc($query)){
		$json[]=$row;
	}

	echo json_encode(
		array('item' => $json), 
		JSON_FORCE_OBJECT
	);
?>
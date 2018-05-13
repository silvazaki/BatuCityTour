# CarAnimation
Demo Aplikasi tentang pariwisata dengan animasi mobil berjalan
<br><br>
# Demo
<img src="https://github.com/silvazaki/BatuCityTour/blob/master/batu-guide.gif"/>
<br>
<br><br>
# Demo
<img src="https://github.com/silvazaki/BatuCityTour/blob/master/car-animation.gif"/>
<br>
Youtube Link: ""
<br><br>
APIs yang digunakan
<UL>
<LI>Google Maps Api</LI>
<LI>Google Maps Directions API</LI>
<LI>Volley</LI>
</UL>

<br><br>
# Penjelasan Sedikit Tentang Animasi
Steps:
<UL>
<LI>Ganti polyline dengan parameter tempat yang anda inginkan:
<pre>
<code>
"https://maps.googleapis.com/maps/api/directions/json?" +
                    "mode=driving&"
                    + "transit_routing_preference=less_driving&"
                    + "origin=" + latitude + "," + longitude + "&"
                    + "destination=" + destination + "&"
                    + "key=" + getResources().getString(R.string.google_directions_key)
</code>
</pre>
</LI>

<br><br>
# Running the project
The application uses <b>Google Maps Api Key</b> and <b>Google Map Directions key</b>. Get these api key on google developers console after enabling them for your project. Replace your google maps directions api key in <a href="https://github.com/amanjeetsingh150/UberCarAnimation/blob/master/app/src/main/res/values/strings.xml">strings.xml</a> and google maps key in <a href="https://github.com/amanjeetsingh150/UberCarAnimation/blob/master/app/src/debug/res/values/google_maps_api.xml">google_maps_api.xml</a>. For convenience a TODO has been added there just follow them.
<br><br>

<br><br>
# Inspiration
This source code inspired by amanjeetsingh150 https://github.com/amanjeetsingh150
<br><br>
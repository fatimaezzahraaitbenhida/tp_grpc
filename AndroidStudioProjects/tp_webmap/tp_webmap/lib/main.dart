import 'package:flutter/material.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:latlong2/latlong.dart'; // For LatLng
import 'package:http/http.dart' as http;
import 'dart:convert';

void main() {
  runApp(const WebMapApp());
}

class WebMapApp extends StatelessWidget {
  const WebMapApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Web Mapping App',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MapPage(),
    );
  }
}

class MapPage extends StatefulWidget {
  const MapPage({super.key});

  @override
  State<MapPage> createState() => _MapPageState();
}

class _MapPageState extends State<MapPage> {
  final List<Marker> _markers = [];

  @override
  void initState() {
    super.initState();
    _fetchPharmacyData();
  }

  Future<void> _fetchPharmacyData() async {
    const url = 'https://api.jsonbin.io/v3/b/658212f71f5677401f10889b';
    try {
      final response = await http.get(Uri.parse(url));
      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        List<dynamic> pharmacies = data['record']['pharmacies'];

        setState(() {
          _markers.addAll(pharmacies.map((pharmacy) {
            return Marker(
              width: 80.0,
              height: 80.0,
              point: LatLng(pharmacy['latitude'], pharmacy['longitude']),
              child: const Icon(
                Icons.location_pin,
                color: Colors.red,
                size: 40,
              ),
            );
          }));
        });
      }
    } catch (e) {
      print('Error fetching pharmacy data: $e');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Flutter WebMapping Example'),
      ),
      body: FlutterMap(
        options: MapOptions(
          center: LatLng(35.6895, -5.8339), // Default center
          zoom: 10.0,
        ),
        children: [
          TileLayer(
            urlTemplate:
            "https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png",
            subdomains: const ['a', 'b', 'c'],
          ),
          MarkerLayer(markers: _markers),
        ],
      ),
    );
  }
}

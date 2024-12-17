


import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:latlong2/latlong.dart';

class Carte0 extends StatelessWidget{

  Carte0({super.key});

  @override
  Widget build(BuildContext context )
  {

    return Scaffold(
      body: Stack(children: [
        FlutterMap(
          options: const MapOptions(
            initialCenter: LatLng(31.63139639931016,-8.01278402883554),
            initialZoom: 10,
          ),
          children: [
            TileLayer(
              urlTemplate: 'https://tile.openstreetmap.org/{z}/{x}/{y}.png',
              userAgentPackageName: 'com.example.app',

            ),
          ]),
      ]));
  }
}

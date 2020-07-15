"use strict";
(function(){
    $(document).ready(function() {
        // var latValue = 0;
        // var longValue = 0;
        //
        // (function initLocation () {
        //     latValue = 32.79;
        //     longValue = -96.79;
        // })();
        //
        // // MAPBOX ==========================================================>
        //
        // var marker = {};
        // function createMapBox (mapboxToken, result) {
        //     if(result !== undefined) {
        //         longValue = result[0];
        //         latValue = result[1];
        //     }
        //     mapboxgl.accessToken = mapboxToken;
        //     let map = new mapboxgl.Map({
        //         container: 'map',
        //         style: 'mapbox://styles/mapbox/streets-v11',
        //         center: [-96.79, 32.79],
        //         zoom: 5
        //     });
        //
        //     let marker = new mapboxgl.Marker({
        //         draggable: true
        //     })
        //         .setLngLat([longValue, latValue ])
        //         .addTo(map);
        //     map.flyTo({center: [longValue, latValue], zoom: 9});
        //
        //     function onDragEnd() {
        //         let lngLat = marker.getLngLat();
        //         let latValue = lngLat.lat;
        //         let longValue = lngLat.lng;
        //         locationExecution(latValue, longValue);
        //     }
        //     marker.on('dragend', onDragEnd);
        // }
        // createMapBox(mapboxToken);

        // MAPBOX ==========================================================>

        // function locationExecution (latValue, longValue) {
        //     let lat = latValue;
        //     let long = longValue;
        //     $.ajax({
        //         "url": "https://api.openweathermap.org/data/2.5/forecast",
        //         "type": "GET",
        //         "data": {
        //             "APPID": OWM_KEY,
        //             "lat":    lat,
        //             "lon":   long,
        //             "units": "Imperial"
        //         }
        //     }).done(function (data) {
        //         $('#forecast').empty();
        //         let dataArr = data.list;
        //         console.log(dataArr);
        //         setCity(data);
        //         dataArr.forEach( (item, index) => {
        //             if(index % 8 === 0) {
        //                 makeForecast(item);
        //             }
        //         });
        //     }).fail(function (error) {
        //         console.error(error);
        //     });
        // }
        // locationExecution(32.79, -96.79 );

        mapboxgl.accessToken = mapboxToken;

        var restaurants = [
            {
                name: 'Hopdoddy Burger Bar',
                address: '3227 McKinney Ave Suite 102, Dallas, TX',
                description: 'Best Burger in '
            },
            {
                name: 'Jin Korean BBQ',
                address: '3810 S Cooper St #130, Arlington, TX 76015',
                description: 'Best Korean bbq in '
            },
            {
                name: 'Texas Roadhouse',
                address: '2490 I-20 Frontage Rd, Grand Prairie, TX 75052',
                description: 'Best Steak in '
            }
        ];



        var zoomLevel = document.getElementById('submit');
        var select = document.getElementById('zoom-level');
        var address = document.getElementById('address');
        console.log(address);


// zoomLevel.addEventListener('click', getZoom);
        select.addEventListener('change', getZoom);


        var option = {
            maxWidth: '300px',
            color: 'red',
            draggable: true,
            anchor: 'bottom-left'

        };

        var map = new mapboxgl.Map({
            container: 'map',
            style: 'mapbox://styles/mapbox/streets-v9',
            zoom: 0,
            center: [-97.14, 32.77]
        });

// The zoom functionality worked but there is no state where the center is so hardcoded setCenter
        function getZoom() {
            map.setZoom(select.value);
            map.setCenter([-97.14, 32.77]);
        }

// Add restaurant
        /*
        restaurants.push({
            name: 'new restaurant',
            address: address.value,
            description: 'Best restaurant in the city of'
        });
        */

        function addRestaurant () {
            restaurants.forEach( (restaurant, index) => {
                geocode(restaurant.address, mapboxToken).then( result => {
                    console.log(result);

                    //    add additional code for geocode
                    geoRestaurant(result, restaurant);
                });
            });
        }


        function geoRestaurant(result, restaurant) {

            var popup = new mapboxgl.Popup()
                .setHTML(`<h3>${restaurant.name}<br>${restaurant.address}<br><hr> ${restaurant.description} <em>${restaurant.address.split(',')[1]}</em></h3>`);

            new mapboxgl.Marker(option)
                .setLngLat(result)
                .setPopup(popup)
                .addTo(map)

        }

        addRestaurant();

    });
})();
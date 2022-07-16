# BookStore App - BKM

![](https://img.shields.io/badge/build-success-brightgreen.svg)

# Stack

![](https://img.shields.io/badge/java_8-✓-blue.svg)
![](https://img.shields.io/badge/spring_boot-✓-blue.svg)
![](https://img.shields.io/badge/hibernate-✓-blue.svg)
![](https://img.shields.io/badge/hibernate-✓-blue.svg)
![](https://img.shields.io/badge/log4j-✓-blue.svg)
![](https://img.shields.io/badge/jwt-✓-blue.svg)
![](https://img.shields.io/badge/swagger_2-✓-blue.svg)
![](https://img.shields.io/badge/docker-✓-blue.svg)
![](https://img.shields.io/badge/heroku-✓-blue.svg)

***

<h3 align="center">I hope you will like it :blush:</h3>

***

# Introduction

The bookstore is online books retail firm which operates only on internet. 
Main target of the bookstore is deliver books to their customer within the same day.

Let’s take a look:

## Database

A heroku cloud postgreSQL database is used. 

## Docker
This application is containerized.

You can pull image following url:

https://hub.docker.com/repository/docker/talhadocker1/bookstoreapp

## Unit Test

There are 6 unit tests.

- Generate Token
- Get Username From Token
- Create Customer
- Create Order
- Get Orders
- Get Order Detail

## Swagger

Swagger is implemented for all endpoints.

https://bookstore-bkm.herokuapp.com/swagger-ui.html

## Deployment

Application is deployed to heroku cloud. 

Project URL: https://bookstore-bkm.herokuapp.com/swagger-ui.html

## Logging

Log4j dependency is implemented for logging.

### Table and data examples

Customer Table 
```
 customer_id |             email             |  last_update_date   | last_updated_user |    name    |                           password                           |     phone     |     record_date     | status |    surname    |    username    | address_id
-------------+-------------------------------+---------------------+-------------------+------------+--------------------------------------------------------------+---------------+---------------------+--------+---------------+----------------+------------
           1 | mraittie0@bravesites.com      | 2021-09-08 00:00:00 | Timmie            | Mordy      | $2a$10$VbuPFD8TNG4Y2z/sRGD7ledl9t2KU47BYZW1rE7VD1eXvwMugxmtS | (254) 5359506 | 2021-10-26 00:00:00 | A      | Raittie       | admin          |          1
           2 | icoils1@goo.ne.jp             | 2021-08-21 00:00:00 | Esmeralda         | Ingar      | $2a$10$VbuPFD8TNG4Y2z/sRGD7ledl9t2KU47BYZW1rE7VD1eXvwMugxmtS | (487) 5147346 | 2021-09-28 00:00:00 | A      | Coils         | icoils1        |          2
           3 | rebbitt2@slashdot.org         | 2021-07-03 00:00:00 | Vicki             | Reagan     | $2a$10$VbuPFD8TNG4Y2z/sRGD7ledl9t2KU47BYZW1rE7VD1eXvwMugxmtS | (622) 2543216 | 2021-11-20 00:00:00 | A      | Ebbitt        | rebbitt2       |          3
           4 | pwestcot3@mashable.com        | 2021-05-30 00:00:00 | Perla             | Papageno   | $2a$10$VbuPFD8TNG4Y2z/sRGD7ledl9t2KU47BYZW1rE7VD1eXvwMugxmtS | (836) 6909287 | 2021-07-03 00:00:00 | A      | Westcot       | pwestcot3      |          4
           5 | hsallarie4@hubpages.com       | 2022-01-30 00:00:00 | Gregoor           | Heath      | $2a$10$VbuPFD8TNG4Y2z/sRGD7ledl9t2KU47BYZW1rE7VD1eXvwMugxmtS | (552) 4016956 | 2021-08-02 00:00:00 | A      | Sallarie      | hsallarie4     |          5
           6 | babbys5@cocolog-nifty.com     | 2022-01-01 00:00:00 | Nikolai           | Brantley   | $2a$10$VbuPFD8TNG4Y2z/sRGD7ledl9t2KU47BYZW1rE7VD1eXvwMugxmtS | (800) 7601734 | 2022-02-05 00:00:00 | A      | Abbys         | babbys5        |          6
           7 | wrowlatt6@meetup.com          | 2021-08-25 00:00:00 | Carleton          | Web        | $2a$10$VbuPFD8TNG4Y2z/sRGD7ledl9t2KU47BYZW1rE7VD1eXvwMugxmtS | (148) 3195584 | 2021-08-29 00:00:00 | A      | Rowlatt       | wrowlatt6      |          7
           8 | obradburn7@ning.com           | 2021-09-28 00:00:00 | Hertha            | Obed       | $2a$10$VbuPFD8TNG4Y2z/sRGD7ledl9t2KU47BYZW1rE7VD1eXvwMugxmtS | (274) 7422509 | 2022-02-17 00:00:00 | A      | Bradburn      | obradburn7     |          8
           9 | svanderbeken8@issuu.com       | 2021-08-14 00:00:00 | Morgan            | Sinclare   | $2a$10$VbuPFD8TNG4Y2z/sRGD7ledl9t2KU47BYZW1rE7VD1eXvwMugxmtS | (126) 7511101 | 2021-10-03 00:00:00 | A      | Van der Beken | svanderbeken8  |          9
          10 | kmorot9@sitemeter.com         | 2022-03-05 00:00:00 | Wanda             | Kristoforo | $2a$10$VbuPFD8TNG4Y2z/sRGD7ledl9t2KU47BYZW1rE7VD1eXvwMugxmtS | (817) 6862820 | 2021-08-09 00:00:00 | A      | Morot         | kmorot9        |         10
```

Address table
```
 address_id |          address          |         city          |    country    | postal_code |     record_date
------------+---------------------------+-----------------------+---------------+-------------+---------------------
          1 | 849 Del Mar Junction      | Hebian                | China         |             | 2022-03-27 00:00:00
          2 | 59402 Erie Plaza          | Fenjie                | China         |             | 2021-08-16 00:00:00
          3 | 5136 4th Pass             | Niederwaldkirchen     | Austria       | 4174        | 2021-08-21 00:00:00
          4 | 89 Ruskin Center          | WuÆerqihan            | China         |             | 2021-08-11 00:00:00
          5 | 03202 Springview Junction | Shamakhi              | Azerbaijan    |             | 2021-06-29 00:00:00
          6 | 42794 Brentwood Lane      | Enschede              | Netherlands   | 7534        | 2021-04-18 00:00:00
          7 | 67 Banding Trail          | Sibanic·              | Cuba          |             | 2022-03-12 00:00:00
          8 | 0249 Becker Terrace       | Lisewo                | Poland        | 86-230      | 2021-10-21 00:00:00
          9 | 35 Orin Park              | Belanting             | Indonesia     |             | 2022-01-27 00:00:00
         10 | 5310 Montana Point        | Boulogne-Billancourt  | France        | 92660 CEDEX | 2021-06-15 00:00:00
```

Book Table
```
 book_id |       author        | price |     record_date     |           title
---------+---------------------+-------+---------------------+----------------------------
       1 | Kalil Meeson        |     5 | 2021-11-14 00:00:00 | Corvus albus
       2 | Orazio Giacomo      |   2.9 | 2021-11-27 00:00:00 | Bubo virginianus
       3 | Daloris Tompkinson  | 17.79 | 2021-11-30 00:00:00 | Delphinus delphis
       4 | Malvina Seery       | 13.28 | 2022-01-02 00:00:00 | Picoides pubescens
       5 | Erika Stearn        |  1.29 | 2021-12-30 00:00:00 | Gyps fulvus
       6 | Pansy Cornell       | 14.62 | 2021-09-15 00:00:00 | Seiurus aurocapillus
       7 | Paloma Duigenan     |  7.64 | 2022-03-01 00:00:00 | Speotyte cuniculata
       8 | Mark Tiffin         |  12.6 | 2021-09-25 00:00:00 | Centrocercus urophasianus
       9 | Berkeley Brabender  | 10.63 | 2022-02-05 00:00:00 | Papio cynocephalus
      10 | Elmira Egginton     | 13.77 | 2021-09-27 00:00:00 | Libellula quadrimaculata
```

Order Table
```
 order_id |      last_update_date      | last_updated_user |         order_date         | order_status | total_price | customer_id
----------+----------------------------+-------------------+----------------------------+--------------+-------------+-------------
        1 | 2022-04-13 21:53:01.42422  | MOBILEAPP         | 2022-04-13 21:53:01.42422  | WAITING      |       25.69 |           1
        2 | 2022-04-13 21:53:13.527196 | MOBILEAPP         | 2022-04-13 21:53:13.527196 | WAITING      |       75.12 |           1
        3 | 2022-04-13 21:53:17.492521 | MOBILEAPP         | 2022-04-13 21:53:17.492521 | WAITING      |       54.88 |           1
        4 | 2022-04-13 21:53:32.669414 | MOBILEAPP         | 2022-04-13 21:53:32.669414 | WAITING      |      134.81 |           1
```

OrderLine Table
```
 order_line_id | price |        record_date         | status | book_id | order_id
---------------+-------+----------------------------+--------+---------+----------
             1 |     5 | 2022-04-13 21:53:01.436605 | A      |       1 |        1
             2 |   2.9 | 2022-04-13 21:53:01.439657 | A      |       2 |        1
             3 | 17.79 | 2022-04-13 21:53:01.440695 | A      |       3 |        1
             4 |     5 | 2022-04-13 21:53:13.530002 | A      |       1 |        2
             5 |   2.9 | 2022-04-13 21:53:13.533038 | A      |       2 |        2
             6 | 17.79 | 2022-04-13 21:53:13.545812 | A      |       3 |        2
             7 | 13.28 | 2022-04-13 21:53:13.546812 | A      |       4 |        2
             8 |  1.29 | 2022-04-13 21:53:13.548906 | A      |       5 |        2
             9 | 14.62 | 2022-04-13 21:53:13.550225 | A      |       6 |        2
            10 |  7.64 | 2022-04-13 21:53:13.552215 | A      |       7 |        2
```

Stock Table
```
 order_line_id | price |        record_date         | status | book_id | order_id
---------------+-------+----------------------------+--------+---------+----------
             1 |     5 | 2022-04-13 21:53:01.436605 | A      |       1 |        1
             2 |   2.9 | 2022-04-13 21:53:01.439657 | A      |       2 |        1
             3 | 17.79 | 2022-04-13 21:53:01.440695 | A      |       3 |        1
             4 |     5 | 2022-04-13 21:53:13.530002 | A      |       1 |        2
             5 |   2.9 | 2022-04-13 21:53:13.533038 | A      |       2 |        2
             6 | 17.79 | 2022-04-13 21:53:13.545812 | A      |       3 |        2
             7 | 13.28 | 2022-04-13 21:53:13.546812 | A      |       4 |        2
             8 |  1.29 | 2022-04-13 21:53:13.548906 | A      |       5 |        2
             9 | 14.62 | 2022-04-13 21:53:13.550225 | A      |       6 |        2
            10 |  7.64 | 2022-04-13 21:53:13.552215 | A      |       7 |        2
```
## Restful Endpoints

1. `Create Customer`
2. `Generate JWT Token`
3. `Create New Order`
4. `List All Orders`
5. `Get Order Detail`
6. `Update Stock`
 
**1- Create Customer**

* Api Url: https://bookstore-bkm.herokuapp.com/customer/create
* Mapping Type : POST
* Authentication : Not Required
* Request Example
```
{
    "username": "superadmin",
    "password": "123456",
    "name": "ali",
    "surname": "veli",
    "email": "ali@email.com",
    "phone": "05552555555",
    "address": {
        "address": "akaretler",
        "city": "istanul",
        "country": "turkiye",
        "postalCode": "34526"
    }
}
```

* Response Example
```
{
    "message": "User registered successfully!"
}
```

**2- Generate JWT Token**

* Api Url: https://bookstore-bkm.herokuapp.com/generatetoken
* Mapping Type : POST
* Authentication : Not Required
* Request Example
```
{
    "username": "superadmin",
    "password": "123456"
}
```

* Response Example
```
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY0OTg5NzY1NywiaWF0IjoxNjQ5ODc5NjU3fQ.3tzCwC4CalIKmXkCTW6XQwbkCGxYb00gar--SiedgpaJdoDnLk72j_BrSkva3qYeYY8LiN2uzXk8o4jF1pm0wQ"
}
```

**3- Create New Order**

* Api Url: https://bookstore-bkm.herokuapp.com/order/create
* Mapping Type : POST
* Authentication : You have add Baerer Token to header which is created via "generete jwt token" endpoint.
* Book table has to contain bookId which is in request.
* Request Example
```
{
    "bookIds": [
        1,
        2,
        3,
        4,
        9,
        16
    ]
}
```

* Response Example
```
{
    "message": "Order is created successfully!"
}
```

**4- List All Orders**

* Api Url: https://bookstore-bkm.herokuapp.com/order/list
* Mapping Type : POST
* Authentication : You have add Baerer Token to header which is created via "generete jwt token" endpoint.
* Request Example
```
{}
```

* Response Example
```
[
    {
        "orderId": 1,
        "orderStatus": "WAITING",
        "orderDate": "2022-04-13 17:22:48",
        "totalPrice": 25.69
    },
    {
        "orderId": 3,
        "orderStatus": "WAITING",
        "orderDate": "2022-04-13 20:54:58",
        "totalPrice": 53.98
    },
    {
        "orderId": 4,
        "orderStatus": "WAITING",
        "orderDate": "2022-04-13 20:56:06",
        "totalPrice": 92.41
    },
    {
        "orderId": 5,
        "orderStatus": "WAITING",
        "orderDate": "2022-04-13 20:56:11",
        "totalPrice": 7.9
    },
    {
        "orderId": 6,
        "orderStatus": "WAITING",
        "orderDate": "2022-04-13 20:56:20",
        "totalPrice": 33.39
    },
    {
        "orderId": 7,
        "orderStatus": "WAITING",
        "orderDate": "2022-04-13 20:56:24",
        "totalPrice": 28.39
    },
    {
        "orderId": 8,
        "orderStatus": "WAITING",
        "orderDate": "2022-04-13 20:56:40",
        "totalPrice": 92.27
    }
]
```

**5- Get Order Detail**

* Api Url: https://bookstore-bkm.herokuapp.com/order/detail
* Mapping Type : POST
* Authentication : You have add Baerer Token to header which is created via "generete jwt token" endpoint.
* Request Example
```
{
    "orderId": 8
}
```

* Response Example
```
{
    "orderId": 8,
    "orderStatus": "WAITING",
    "orderDate": "2022-04-13 20:56:40",
    "totalPrice": 92.27,
    "orderLines": [
        {
            "orderLineId": 29,
            "book": {
                "bookId": 1,
                "title": "Corvus albus",
                "author": "Kalil Meeson",
                "price": 5.0
            },
            "price": 5.0,
            "status": "A",
            "recordDate": "2022-04-13 20:56:40"
        },
        {
            "orderLineId": 30,
            "book": {
                "bookId": 2,
                "title": "Bubo virginianus",
                "author": "Orazio Giacomo",
                "price": 2.9
            },
            "price": 2.9,
            "status": "A",
            "recordDate": "2022-04-13 20:56:40"
        },
        {
            "orderLineId": 31,
            "book": {
                "bookId": 3,
                "title": "Delphinus delphis",
                "author": "Daloris Tompkinson",
                "price": 17.79
            },
            "price": 17.79,
            "status": "A",
            "recordDate": "2022-04-13 20:56:40"
        },
        {
            "orderLineId": 32,
            "book": {
                "bookId": 4,
                "title": "Picoides pubescens",
                "author": "Malvina Seery",
                "price": 13.28
            },
            "price": 13.28,
            "status": "A",
            "recordDate": "2022-04-13 20:56:40"
        },
        {
            "orderLineId": 33,
            "book": {
                "bookId": 9,
                "title": "Papio cynocephalus",
                "author": "Berkeley Brabender",
                "price": 10.63
            },
            "price": 10.63,
            "status": "A",
            "recordDate": "2022-04-13 20:56:40"
        },
        {
            "orderLineId": 34,
            "book": {
                "bookId": 16,
                "title": "Felis chaus",
                "author": "Alphonso Plain",
                "price": 4.38
            },
            "price": 4.38,
            "status": "A",
            "recordDate": "2022-04-13 20:56:40"
        },
        {
            "orderLineId": 35,
            "book": {
                "bookId": 25,
                "title": "Neotis denhami",
                "author": "Padgett Snar",
                "price": 10.04
            },
            "price": 10.04,
            "status": "A",
            "recordDate": "2022-04-13 20:56:40"
        },
        {
            "orderLineId": 36,
            "book": {
                "bookId": 48,
                "title": "Geochelone elegans",
                "author": "Esme Capun",
                "price": 17.88
            },
            "price": 17.88,
            "status": "A",
            "recordDate": "2022-04-13 20:56:40"
        },
        {
            "orderLineId": 37,
            "book": {
                "bookId": 49,
                "title": "Phalacrocorax brasilianus",
                "author": "Marshall Babin",
                "price": 0.67
            },
            "price": 0.67,
            "status": "A",
            "recordDate": "2022-04-13 20:56:40"
        },
        {
            "orderLineId": 38,
            "book": {
                "bookId": 50,
                "title": "Echimys chrysurus",
                "author": "Jamesy Ossipenko",
                "price": 9.7
            },
            "price": 9.7,
            "status": "A",
            "recordDate": "2022-04-13 20:56:40"
        }
    ]
}
```

**6- Update Stock**

* Api Url: https://bookstore-bkm.herokuapp.com/stock/update
* Mapping Type : POST
* Authentication : You have add Baerer Token to header which is created via "generete jwt token" endpoint.
* Book table has to contain bookId which is in request.
* Only admin can call this endpoint!
* Request Example
```
{
    "bookId": 1,
    "stockCount": 30
}
```

* Response Example
```
{
    "message": "Stock is updated successfully!"
}
```

## File structure

```
+--src/
|  +--main/
|  |  +--java/
|  |  |  +--com/
|  |  |  |  +--talha/
|  |  |  |  |  +--bookstoreapp/
|  |  |  |  |  |  +--BookstoreAppApplication.java
|  |  |  |  |  |  +--configuration/
|  |  |  |  |  |  |  +--jwt/
|  |  |  |  |  |  |  +--JwtAuthenticationEntryPoint.java
|  |  |  |  |  |  |  +--JwtRequestFilter.java
|  |  |  |  |  |  |  +--JwtTokenUtil.java
|  |  |  |  |  |  |  +--SwaggerConfig.java
|  |  |  |  |  |  |  +--WebSecurityConfig.java
|  |  |  |  |  |  +--controller/
|  |  |  |  |  |  |  +--AuthenticationController.java
|  |  |  |  |  |  |  +--CustomerController.java
|  |  |  |  |  |  |  +--OrderController.java
|  |  |  |  |  |  |  +--StockController.java
|  |  |  |  |  |  +--dto/
|  |  |  |  |  |  |  +--AddressDTO.java
|  |  |  |  |  |  |  +--BookDTO.java
|  |  |  |  |  |  |  +--OrderDetailDTO.java
|  |  |  |  |  |  |  +--OrderDTO.java
|  |  |  |  |  |  |  +--OrderLineDTO.java
|  |  |  |  |  |  |  +--request/
|  |  |  |  |  |  |  |  +--AuthenticationRequestDTO.java
|  |  |  |  |  |  |  |  +--CreateCustomerRequestDTO.java
|  |  |  |  |  |  |  |  +--CreateOrderRequestDTO.java
|  |  |  |  |  |  |  |  +--OrderDetailRequestDTO.java
|  |  |  |  |  |  |  |  +--UpdateStockRequestDTO.java
|  |  |  |  |  |  |  +--response/
|  |  |  |  |  |  |  |  +--AuthenticationResponseDTO.java
|  |  |  |  |  |  |  |  +--MessageResponse.java
|  |  |  |  |  |  +--entity/
|  |  |  |  |  |  |  +--Address.java
|  |  |  |  |  |  |  +--Book.java
|  |  |  |  |  |  |  +--Customer.java
|  |  |  |  |  |  |  +--Order.java
|  |  |  |  |  |  |  +--OrderLine.java
|  |  |  |  |  |  |  +--Stock.java
|  |  |  |  |  |  +--enums/
|  |  |  |  |  |  |  +--OrderStatus.java
|  |  |  |  |  |  |  +--Status.java
|  |  |  |  |  |  +--mapper/
|  |  |  |  |  |  |  +--IAddressMapper.java
|  |  |  |  |  |  |  +--IBookMapper.java
|  |  |  |  |  |  |  +--IOrderMapper.java
|  |  |  |  |  |  +--repository/
|  |  |  |  |  |  |  +--IBookRepository.java
|  |  |  |  |  |  |  +--ICustomerRepository.java
|  |  |  |  |  |  |  +--IOrderLineRepository.java
|  |  |  |  |  |  |  +--IOrderRepository.java
|  |  |  |  |  |  |  +--IStockRepository.java
|  |  |  |  |  |  +--service/
|  |  |  |  |  |  |  +--AsyncService.java
|  |  |  |  |  |  |  +--CustomerService.java
|  |  |  |  |  |  |  +--OrderService.java
|  |  |  |  |  |  |  +--StockService.java
|  |  |  |  |  |  +--util/
|  |  +--resources/
|  |  |  +--application.properties
|  |  |  +--log4j2.xml
|  |  |  +--log4j2.yml.bk
|  +--test/
|  |  +--java/
|  |  |  +--com/
|  |  |  |  +--talha/
|  |  |  |  |  +--bookstoreapp/
|  |  |  |  |  |  |  +--AuthenticationTest.java
|  |  |  |  |  |  |  +--CustomerServiceTest.java
|  |  |  |  |  |  |  +--OrderServiceTest.java
|  |  |  |  |  |  |  +--TestUtil.java
```

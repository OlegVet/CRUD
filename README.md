### CRUD repository access by REST requests

#### Get all countries
GET http://localhost:8080/api/country/all/

#### Get country by id
GET http://localhost:8080/api/country/readById/1

#### Get country by name
GET http://localhost:8080/api/country/readByName/Russia

#### Get country by code
GET http://localhost:8080/api/country/readByCodeName/GE

#### Create country
POST http://localhost:8080/api/country/create/
Content-Type: application/json
{
    "id": 3,
    "name": "USA",
    "codeName": "US"
}

#### Create list of country
POST http://localhost:8080/api/country/createAll/
Content-Type: application/json
{
    "countryList": [
        {
        "id": 8,
        "name": "France",
        "codeName": "FR"
        },
        {
        "id": 9,
        "name": "Great Britain",
        "codeName": "GB"
        }
    ]
}

#### Update country
POST http://localhost:8080/api/country/create/
Content-Type: application/json
{
    "id": 2,
    "name": "Poland",
    "codeName": "PO"
}

#### Delete country
GET http://localhost:8080/api/country/deleteById/2

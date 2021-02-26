# financial-graph-search

## Add a node and Vertex

A new node and a vertex can be added using the insert API.

HTTP Method: **POST**

Path: /api/graph/

Request Body: 
```json
{
  "childNode": {
    "name": "string",
    "nodeId": "string",
    "nodeLevel": 0,
    "type": "INVESTOR",
    "value": 0
  },
  "edgeWeight": 0,
  "parentNode": {
    "name": "string",
    "nodeId": "string",
    "nodeLevel": 0,
    "type": "INVESTOR",
    "value": 0
  }
}
```

Sample Request: 

```
{
  "childNode": {
    "name": "INV1",
    "nodeId": "123456",
    "nodeLevel": 1,
    "type": "INVESTOR",
    "value": null
  },
  "edgeWeight": 10,
  "parentNode": {
    "name": "F1",
    "nodeId": "5781",
    "nodeLevel": 2,
    "type": "FUND",
    "value": null
  }
}
```

## Get Total Market Value

To get the total Market Value of any Investor or a Fund supply the FundId or the investor id as the nodeId. The optional Parameter "exclusionList" is also provided to exclude the holdings.

The value of the holding Id should be provided in the array. Check the sample request for details.

HTTP METHOD: **POST**

PATH: /api/graph/marketValue

Request Body:

``` json
{
  
  "nodeId": "string",
  "exclusionList" : ["string"]

}
```

Sample Request

```json
{
  
  "nodeId": "5781",
  "exclusionList" : ["67819"]

}
```

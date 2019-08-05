# BRICKSCACI
Ordering system for an organization that sells bricks
## Stack
Rest services using Spring Boot

## Services
We used HashMap as storage repository and used RestController to produce rest services.

Following are the rest services.

### 1. Making an order 

   Path: "/createOrder"
 
  Description: This service used to make an order.
  
 Sample JSON input:
 ```
 {
	"customerName":"Ramesh",
	"customerAddress" : "Hyderabad",
	"quantity" : 4000,
	"orderId" : "BO1564991751877"
}
```
We read the above JSON object with the help of rest controller and storing it into HashMap.

### 2. Getting all orders 

  Path: "/getOrders"
 
  Description: This service used to retirve all orders.
  
  We retrieve all orders in the form of List of JSON objects.
  
### 3. Getting an order details 

   Path: "/getOrder"
 
  Description: This service used to retrive particular order based on order id.
  
  We checking the given order id exists in the repository or not. If order exists then we retrieve the order details 
  for given order id.
  
### 4. Change order

   Path: "/updateOrder"
 
  Description: This service used to update particular order quanity based on order id before order is dispatched.
  
  We checking the given order id exists in the repository or not. If order exists then we retrieve the order details 
  for given order id and update the order with given quantity.
  
### 5. Dispatch order

   Path: "/fulfillOrder"
 
  Description: This service used to dispatch particular order based on order id.
  
  We checking the given order id exists in the repository or not. If order exists then we dispatch the order based on request.

#Simle API Test

1.Start API Server
> ./gradlew bootRun

2.Get a product for inventory service
> http://localhost:8084/products/inventory/111

With example Data

```json
{
	"data":{
		"attributes": {
            "sku": "6009901",
            "title": "Apple - iPhone X 64GB - Space Gray (Verizon)",
            "spec": "64GB - Space Gray (Verizon)"
		}	
	}
	
}
```

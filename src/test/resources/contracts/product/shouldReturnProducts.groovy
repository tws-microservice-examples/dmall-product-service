package product

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            name('should return product')
            request {
                method GET()
                url ('/products') {
                    queryParameters {
                        parameter('skus', '6009907')
                        parameter('skus', '6009901')
                        parameter('skus', '600990')
                    }
                }
            }
            response {
                status(200)
                headers {
                    header('''Content-Type''', '''application/json;charset=UTF-8''')
                }
                body """
                    [
                        {
                            "sku": "6009907",
                            "title": "Apple - iPhone X 64GB - Silver (Verizon)",
                            "spec": "64GB - Silver (Verizon)",
                            "brand": "apple",
                            "pic": "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6009/6009887_sd.jpg;maxHeight=640;maxWidth=550",
                            "price": 799.99
                        },
                        {
                            "sku": "6009901",
                            "title": "Apple - iPhone X 64GB - Space Gray (Verizon)",
                            "spec": "64GB - Space Gray (Verizon)",
                            "brand": "apple",
                            "pic": "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6009/6009887_sd.jpg;maxHeight=640;maxWidth=550",
                            "price": 799.99
                        }
                    ]
                """
            }
        },

        Contract.make {
            name('should return single product')
            request {
                method GET()
                url ('/products') {
                    queryParameters {
                        parameter('skus', '6009907')
                    }
                }
            }
            response {
                status(200)
                headers {
                    header('''Content-Type''', '''application/json;charset=UTF-8''')
                }
                body """
                    [
                        {
                            "sku": "6009907",
                            "title": "Apple - iPhone X 64GB - Silver (Verizon)",
                            "spec": "64GB - Silver (Verizon)",
                            "brand": "apple",
                            "pic": "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6009/6009887_sd.jpg;maxHeight=640;maxWidth=550",
                            "price": 799.99
                        }
                    ]
                """
            }
        }
]
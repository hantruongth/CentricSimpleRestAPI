<h1>Centric Simple REST API</h1>

<h2>H2 Database</h2>
URL: http://localhost:8080/h2-console/ <br/>
JDBC URL: jdbc:h2:mem:centric<br/>
Username:centric<br/>
Password:<br/>
<img src="simple-product-api/src/main/resources/static/images/h2.JPG" width="600"/><br/>
<img src="simple-product-api/src/main/resources/static/images/db.png" width="800"/><br/>

<h2>Run Application</h2>
<strong>Windows</strong>: mvnw spring-boot:run <br/>
<strong>Linux</strong>: ./mvnw spring-boot:run


<h2>Add New Product</h2>
POST - http://localhost:8080/v1/products
<h3>Request Body</h3>
<pre><code>
{
    "name": "Product 1",
    "description": "Red hugo boss shirt",
    "brand": "Hugo Boss",
    "category": "Test2",
    "tags": [
        "red",
        "shirt",
        "BLUE",
        "slim fit"
    ]
}
</code></pre>
<h3>Response</h3>
<pre><code>
{
    "id": "51a64a23-8f0b-4169-a2c3-a2ffb9418750",
    "name": "Product 1",
    "description": "Red hugo boss shirt",
    "brand": "Hugo Boss",
    "category": "Test2",
    "tags": [
        "red",
        "shirt",
        "BLUE",
        "slim fit"
    ],
    "created_at": "2021-07-23T22:14:57Z"
}
</code></pre>
<img src="simple-product-api/src/main/resources/static/images/add.png" width="500"/>

<h2>Search Product by Category Name</h2>
GET - http://localhost:8080/v1/products?category=Test&pageNo=0&pageSize=5&sortBy=createdDate
<h3>Response</h3>
<pre><code>
[
    {
        "id": "281961ab-25ab-4ffe-9d99-6450da8bdfb8",
        "name": "Product 6",
        "description": "Red hugo boss shirt",
        "brand": "Hugo Boss",
        "category": "Test2",
        "tags": [
            "red",
            "shirt",
            "BLUE",
            "slim fit"
        ],
        "created_at": "2021-07-23T22:16:48Z"
    },
    {
        "id": "6041094a-5eab-462c-ad08-4aa209df96bf",
        "name": "Product 5",
        "description": "Red hugo boss shirt",
        "brand": "Hugo Boss",
        "category": "Test2",
        "tags": [
            "red",
            "shirt",
            "BLUE",
            "slim fit"
        ],
        "created_at": "2021-07-23T22:16:40Z"
    },
    {
        "id": "2a3ce72c-2aaf-41f0-bc0b-43b79232e972",
        "name": "Product 4",
        "description": "Red hugo boss shirt",
        "brand": "Hugo Boss",
        "category": "Test2",
        "tags": [
            "red",
            "shirt",
            "BLUE",
            "slim fit"
        ],
        "created_at": "2021-07-23T22:16:37Z"
    },
    {
        "id": "d5d03d20-f3f3-48bd-ad18-507231b1ee1e",
        "name": "Product 3",
        "description": "Red hugo boss shirt",
        "brand": "Hugo Boss",
        "category": "Test2",
        "tags": [
            "red",
            "shirt",
            "BLUE",
            "slim fit"
        ],
        "created_at": "2021-07-23T22:16:33Z"
    },
    {
        "id": "fb0b9df6-e1b2-4dca-85a8-a12ae7d409b8",
        "name": "Product 2",
        "description": "Red hugo boss shirt",
        "brand": "Hugo Boss",
        "category": "Test2",
        "tags": [
            "red",
            "shirt",
            "BLUE",
            "slim fit"
        ],
        "created_at": "2021-07-23T22:16:27Z"
    }
]

</code></pre>
<img src="simple-product-api/src/main/resources/static/images/search.png" width="600"/>


<h2> API Documentation</h2>
URL: http://localhost:8080/swagger-ui/ <br/>
<img src="simple-product-api/src/main/resources/static/images/apidoc.JPG" width="600"/>
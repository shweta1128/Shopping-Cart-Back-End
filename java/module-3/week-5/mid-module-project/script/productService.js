let productService = {
  allProducts: [
    {
      "productId": 1,
      "productSku": "MUG-023",
      "name": "Solar Geeks coffee mug",
      "description": "Start your day off right!",
      "price": 14.99,
      "imageName": "https://render.fineartamerica.com/images/rendered/default/frontright/mug/images/artworkimages/medium/3/outer-space-nerd-solar-system-planets-sun-moon-chart-galaxy-lover-thomas-larch-transparent.png?&targetx=259&targety=-3&imagewidth=275&imageheight=333&modelwidth=800&modelheight=333&backgroundcolor=000000&orientation=0&producttype=coffeemug-11"
    },
    {
      "productId": 2,
      "productSku": "YET-001",
      "name": "Solar Geeks Yeti",
      "description": "Keep cool all day long.",
      "price": 21.99,
      "imageName": "https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/718YZAeInKL._AC_SL1500_.jpg"
    },
    {
      "productId": 3,
      "productSku": "ART-256",
      "name": "Galactic poster",
      "description": "Beautiful view of a galaxy",
      "price": 9.59,
      "imageName": "https://cdn.shopify.com/s/files/1/0868/3310/products/Andromeda_20Galaxy_0173ea1f-a4a5-4a38-8ac7-4d856a4a9cf6_1024x1024.jpg?v=1489583047"
    },
    {
      "productId": 4,
      "productSku": "TOY-978",
      "name": "Toy rocket",
      "description": "To infinite imagination",
      "price": 39.99,
      "imageName": "https://media.istockphoto.com/id/145156523/photo/rocket.jpg?s=1024x1024&w=is&k=20&c=oJYjTOMEPGPO7CxMPeJQ5kcksyEqnOPbvuUiNq633Gg="
    },
    {
      "productId": 5,
      "productSku": "EAT-235",
      "name": "Astronaut ice cream",
      "description": "As cold as space",
      "price": 5.79,
      "imageName": "https://img.freepik.com/free-vector/astronaut-ice-cream-cone-cartoon-illustration-science-food-concept-isolated-flat-cartoon-style_138676-3424.jpg?w=826&t=st=1678581050~exp=1678581650~hmac=f5a31d0ce60e65f0e6d40a4b6fcedb4d7f21174d285bf867a5d3e4e99a7aebaf"
    },
    {
      "productId": 6,
      "productSku": "HAT-928",
      "name": "Solar Geeks baseball cap",
      "description": "Look stylish with our logo",
      "price": 16.89,
      "imageName": "https://i.etsystatic.com/30059732/r/il/be30d1/4758116225/il_1140xN.4758116225_ry72.jpg"
    },
    {
      "productId": 7,
      "productSku": "LIT-612",
      "name": "Intro to Astrophysics",
      "description": "Learn about astrophysics",
      "price": 7.99,
      "imageName": "http://planetary-science.org/wp-content/uploads/2014/09/black-hole.jpg"
    }
  ],

  getProducts() {
    return this.allProducts;
  },

  getProductById(id) {
    this.allProducts.forEach((item) => {
      if (item.productId == id) {
        // window.alert('Items added to the list') ;
        return item;

      }
    }); 
    return null;
  }

  
  
  };




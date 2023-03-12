/*
    app.js

*/

function productLoading(){
    const products = productService.getProducts();
    let sectionCards = document.getElementById("product-cards");
    sectionCards.innerHTML = "";
    for(let product of products){
        let createdCard = makeCard(product);
        sectionCards.appendChild(createdCard);
    }
}



function makeCard(product){
    const article = document.createElement("article");
    article.classList.add("product-card");

 //to get sku
    let sku = document.createElement("div");
    sku.classList.add("sku");
    sku.innerText = product.productSku;
    article.appendChild(sku);

// to get price
let divPrice = document.createElement("div");
divPrice.classList.add("price");
divPrice.innerText = product.price;
article.appendChild(divPrice);

// to get the image
let divImage = document.createElement("div");
divImage.classList.add("product-image");
let image = document.createElement("img");
image.src = product.imageName;
divImage.appendChild(image);
article.appendChild(divImage);

// to get description

// let divDescription = document.createElement("div");
// divDescription.classList.add("description");
// article.appendChild(divDescription);

//to get the name
let divName = document.createElement("div");
divName.classList.add("product-name");
divName.innerText = product.name;
divName.setAttribute("data-id", product.productId);
article.appendChild(divName);
divName.addEventListener('click' , () => {
    window.alert(product.description);
    document.getElementById("status").innerText = product.description;
}) 


// to get the cart

let divCart = document.createElement("div");
divCart.classList.add("cart");
article.appendChild(divCart);
let cartIcon = document.createElement("i");
cartIcon.classList.add("fa-solid" ,  "fa-cart-plus",  "icon" , "action");
cartIcon.setAttribute("title","Add item to cart");
divCart.appendChild(cartIcon);
article.appendChild(divCart);
divCart.addEventListener('click', () => {
    window.alert(product.name + " Added to Cart !");
    document.getElementById("status").innerText = product.name + " Added to Cart !";
})
return article;

}


function filterSearchProducts(){
    const searchClick = document.getElementById("search").value;
    let allProducts = productService.getProducts();
    if(searchClick){
        allProducts = allProducts.filter((product) => {
            return product.name.toLowerCase().includes(searchClick.toLowerCase());
        });
    }
       document.getElementById("product-cards").innerHTML = "";

    allProducts.forEach((item) => {
        const element = makeCard(item);
        const cardSection = document.getElementById('product-cards');
        cardSection.appendChild(element);
    })
}

document.addEventListener('DOMContentLoaded', () => {
    productService.getProducts().forEach((item) => {
        const element = makeCard(item);
        const cardSection = document.getElementById('product-cards');
        cardSection.appendChild(element);

        const searchClick = document.getElementById("search");
        searchClick.addEventListener('keyup', filterSearchProducts);






    });



// const clickName = document.querySelectorAll(".product-name");
// clickName.forEach((item) => {
//     item.addEventListener('click', (event) => {
//         const num = Number(event.currentTarget.getAttribute("data-id"));
//          const product = productService.getProductById(num);
//           window.alert(product.description);
     
//         function displayProductOnClick(event){
//             const num = Number(event.currentTarget.getAttribute("data-id"));
//             const product = productService.allProducts;
//             allProducts.forEach((eachProduct) => {
//                 if(eachProduct == num){
//                     window.alert(eachProduct.divDescription);
//                 }
//             });
// //          
//         }


    






});



// function makeCard(product) {

//     const article = document.createElement("article");
//     article.classList.add("product-card");
//     // $ means variable name looking at currently
//     const html = `
//             <div class="sku">${product.productSku}</div>
//             <div class="price">${product.price}</div>
//             <div class="product-name action" data-id="${product.productId}">${product.name}</div>
//             <div class="product-image">
//               <img src="${product.imageName}">
//             </div>
//             <div class="cart">
//               <i class="fa-solid fa-cart-plus icon action" title="Add item to cart"></i>
//             </div>
    
//        `

//     article.innerHTML = html;
//     const productName = document.querySelector('.action');
//     productName.addEventListener('click', ()=> {
//        window.alert(product.description);
//        document.getElementById('status').innerText = product.description;
//     });

//     return article;

// }



//     const allProductNames = document.querySelectorAll('.product-name');
    
//      allProductNames.forEach((name) => {
//         name.addEventListener('click', () => {
//             const descriptions = name.getAttribute('description');
//             // const id = Number(event.currentTarget.getAttribute("data-id"));
//             // const product = productService.getProductById(id);
//             // const set = div.setAttribute("data-id", product.productId);
//             window.alert(product.innerText);

//         });

//     });


// });

// function setCurrency(value){
//     return new Intl.NumberFormat(`en-US`, {
//         currency: `USD`,
//         style: "currency",
//     }).format(value);

// }
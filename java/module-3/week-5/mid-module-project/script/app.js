/*
    app.js

*/
function makeCard(product) {

    const article = document.createElement("article");
    article.classList.add("product-card");
    // $ means variable name looking at currently
    const html = `
            <div class="sku">${product.productSku}</div>
            <div class="price">${product.price}</div>
            <div class="product-name action" data-id="${product.productId}">${product.description}</div>
            <div class="product-image">
              <img src="${product.imageName}">
            </div>
            <div class="cart">
              <i class="fa-solid fa-cart-plus icon action" title="Add item to cart"></i>
            </div>
    
       `

    article.innerHTML = html;
    return article;

}


document.addEventListener('DOMContentLoaded', () => {
    productService.getProducts().forEach((item) => {
        const element = makeCard(item);
        const cardSection = document.getElementById('product-cards');
        cardSection.appendChild(element);
    });
   

    const allProductNames = document.getElementById('.product-name');
    const description = document.getElementById('.description');
     allProductNames.forEach((name) => {
        name.addEventListener('click', () => {
            // const id = Number(event.currentTarget.getAttribute("data-id"));
            // const product = productService.getProductById(id);
            // const set = div.setAttribute("data-id", product.productId);
            window.alert(product.innerText);

        });

    });


});









// function productLoading(){
//     const products = productService.getProducts();
//     let sectionCards = document.getElementById("product-cards");
//     sectionCards.innerHTML = "";
//     for(let product of products){
//         let createdCard = makeCard(product);
//         sectionCards.appendChild(createdCard);
//     }
// }



// function makeCard(product){
//     const article = document.createElement("article");
//     article.classList.add("product-card");


//     //to get sku
//     let sku = document.createElement("div");
//     sku.classList.add("sku");
//     sku.innerText = product.productSku;
//     article.appendChild(sku);




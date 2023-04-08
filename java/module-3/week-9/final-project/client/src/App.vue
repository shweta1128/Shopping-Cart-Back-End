<template>
  <div id="app">
    <header class="page-header">
     <div id="image" class="logo-container">
      <img  src=https://solargeeksa.co.za/wp-content/uploads/2019/09/slider-logo-400h.png>
     </div>
      
    </header>
  
      <nav>
      <div id="Home">
        <router-link v-bind:to="{name: 'products'}" >Home</router-link>
        <router-link v-bind:to="{name: 'cart'}">Cart</router-link>
      
      </div>
      <div>
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token">Logout</router-link>
      <router-link v-bind:to="{ name: 'login' }" v-else>Login</router-link>
      </div>
      
    </nav>

    
    
      
    <main>
      <router-view />
    </main>
    <footer class="copyright">
       <div id="app">
          <p> © copy 2022 All rights reserved.  </p>

        </div>

    </footer>
  </div>
</template>



<style scoped>
   .page-header { 
    display:flex;
    justify-content: center;
    border: 3px solid rgb(233, 213, 213);
    flex-direction: row;
    top: 0;
    background-color: rgb(214, 168, 168);
    height: 200px;
    text-align: center;
    position: sticky;

z-index: 999;
}

.logo-container > img{ 
   width: 300px;
    margin: -7px;
}

/* #Home {
display: flex;
position: sticky;
    z-index: 999;
} */
#Home > a  { 
     
     margin-left: 10px;
     margin-right: 20px;
     text-decoration-color: red;
     color: rgba(14, 12, 12, 0.795);

}
nav {
 background-color: white;
 display: flex;
 margin:0px;
border: 3px solid rgb(182, 28, 28);
justify-content: space-between;
color:rgb(105, 74, 101);

}





</style>
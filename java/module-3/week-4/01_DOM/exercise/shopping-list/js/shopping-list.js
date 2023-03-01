// add pageTitle
const shoppingList = document.getElementById('shopping-list');
let pageTitle = '';
// add groceries
let groceries = ['Sugar', 'Salt',' Onions','Potatoes', 'Apples', 'Banana', 'Brocoli', 'Cucumber', 'Carrots', 'Oil'];
function init(){
  pageTitle = 'My Shopping List';

}
init();
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  
  const title = document.getElementById('title');
     title.innerText = pageTitle;

}
setPageTitle();

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const list = document.getElementById('groceries');
  groceries.forEach(items => {
  const li = document.createElement('li'); // <li></li>  (unmatched)
  li.innerText = items;                    //
  list.appendChild(li);

  });
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  listElements = document.querySelectorAll('li');
  for(let i = 0; i < listElements.length; i++){
    listElements[i].classList.add('completed');
  }
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});

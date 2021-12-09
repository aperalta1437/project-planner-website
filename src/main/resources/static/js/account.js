// $(".form-add-to-cart").on("submit", function (e) {
//   e.preventDefault();
//   var spinner = $("#div-add-to-cart-spinner-container");
//   spinner.fadeIn(250);
//   $.ajax({
//     url: $(this).attr("action"),
//     type: "POST",
//     dataType: "json",
//     data: $(this).serialize(),
//     success: function (response) {
//       spinner.fadeOut(250);
//       var inCartAmountElement = $("#div-in-cart-" + response.requestedItemSku);
//       var cartRequestedItemTotal = response.cartRequestedItemTotal;

//       inCartAmountElement.find(".span-item-total").text(cartRequestedItemTotal);

//       if (cartRequestedItemTotal > 0) {
//         inCartAmountElement.removeClass("d-none");
//       }
//       $("#span-cart-total-items").text(response.cartTotalItems);

//       var addToCartResponseElement = $("#div-add-to-cart-response");
//       addToCartResponseElement.find("span").text(response.addToCartResponse);

//       if (!response.isSuccess) {
//         addToCartResponseElement.css({ opacity: 0, display: "flex" }).animate(
//           {
//             opacity: 1,
//           },
//           1000,
//           function () {
//             addToCartResponseElement.addClass("attention");
//             setTimeout(function () {
//               addToCartResponseElement.fadeOut(1000);
//             }, 7000);
//           }
//         );
//       } else {
//         inCartAmountElement.addClass("change");
//         setTimeout(function () {
//           inCartAmountElement.removeClass("change");
//         }, 3000);
//       }
//     },
//     error: function () {
//       spinner.fadeOut(250);
//       alert("Error while requesting. Please try again later.");
//     },
//   });
//   $(this).trigger("reset");
// });

function addNewList() {
  var newListTemplate = `<div class="list">
        <h3 class="list-title"><input id="input-new-list-name" type="text" style="width: 100%" /></h3>
      </div>`; //it can be anything
  var addListBtn = document.getElementById("btn-add-list"); //any element to be fully replaced
  if (addListBtn.outerHTML) {
    //if outerHTML is supported
    addListBtn.outerHTML = newListTemplate; ///it's simple replacement of whole element with contents of str var
  }

  const inputNewListName = document.getElementById("input-new-list-name");
  inputNewListName.focus();

  document
    .querySelector("#input-new-list-name")
    .addEventListener("keypress", function (e) {
      if (e.key === "Enter") {
        //////////////////////////////////////////////////////////
        var spinner = $("#div-add-to-cart-spinner-container");
        spinner.fadeIn(250);

        var inputNewListNameParentParent =
          inputNewListName.parentNode.parentNode;
        $.ajax({
          url: `/account/add-new-tasks-list/${inputNewListName.value}`,
          type: "POST",
          dataType: "json",
          success: function (response) {
            spinner.fadeOut(250);
            console.log(inputNewListName);
            inputNewListName.outerHTML = inputNewListName.value;
            inputNewListNameParentParent.innerHTML += `<ul class="list-items"></ul>
        <button class="add-card-btn btn">Add a card</button>`;
            var inputNewListNameParentParentParent =
              inputNewListNameParentParent.parentNode;
            inputNewListNameParentParentParent.innerHTML += `<button class="add-list-btn btn" id="btn-add-list">Add a list</button>`;
            document
              .querySelector("#btn-add-list")
              .addEventListener("click", addNewList);
            $(".add-card-btn").each(function () {
              this.addEventListener("click", addNewTask);
            });
            console.log("List was added");
          },
          error: function () {
            spinner.fadeOut(250);
            inputNewListNameParentParent.parentNode.removeChild(
              inputNewListNameParentParent
            );
            alert("Error while requesting. Please try again later.");
            var inputNewListNameParentParentParent =
              inputNewListNameParentParent.parentNode;
            inputNewListNameParentParentParent.innerHTML += `<button class="add-list-btn btn" id="btn-add-list">Add a list</button>`;
            document
              .querySelector("#btn-add-list")
              .addEventListener("click", addNewList);
            $(".add-card-btn").each(function () {
              this.addEventListener("click", addNewTask);
            });
          },
        });
        ////////////////////////////////////////////////////////
      }
    });
}

document.querySelector("#btn-add-list").addEventListener("click", addNewList);

function addNewTask(event) {
  console.log("You wanted to add a task");
  console.log(event.currentTarget);

  var newTaskTemplate = `<li>
            <input id="input-new-task-name" type="text" style="width: 100%" />
          </li>`; //it can be anything
  var addTaskBtn = event.currentTarget; //any element to be fully replaced
  var tasksList = addTaskBtn.parentNode.getElementsByClassName("list-items")[0];
  tasksList.innerHTML += newTaskTemplate;
  addTaskBtn.parentNode.removeChild(addTaskBtn);

  const inputNewTaskName = document.getElementById("input-new-task-name");
  inputNewTaskName.focus();

  document
    .querySelector("#input-new-task-name")
    .addEventListener("keypress", function (e) {
      if (e.key === "Enter") {
        //////////////////////////////////////////////////////////
        var spinner = $("#div-add-to-cart-spinner-container");
        spinner.fadeIn(250);

        var inputNewTaskNameParentParentParent =
          inputNewTaskName.parentNode.parentNode.parentNode;
        $.ajax({
          url: `/account/add-new-task/tasks-list/${
            inputNewTaskNameParentParentParent.getElementsByTagName("h3")[0]
              .innerHTML
          }/task/${inputNewTaskName.value}`,
          type: "POST",
          dataType: "json",
          success: function (response) {
            spinner.fadeOut(250);

            inputNewTaskName.outerHTML = inputNewTaskName.value;
            inputNewTaskNameParentParentParent.innerHTML += `<button class="add-card-btn btn">Add a card</button>`;
            $(".add-card-btn").each(function () {
              this.addEventListener("click", addNewTask);
            });
          },
          error: function () {
            spinner.fadeOut(250);
          },
        });
        ////////////////////////////////////////////////////////
      }
    });

  console.log("End of addNewTask function");
}

$(".add-card-btn").each(function () {
  this.addEventListener("click", addNewTask);
});

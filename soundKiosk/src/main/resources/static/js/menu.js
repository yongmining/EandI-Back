document.addEventListener('DOMContentLoaded', function() {
	const btn_home = document.querySelector('.button-home');
	const menu_coffee = document.querySelector('.menu-coffee');
	const menu_tea = document.querySelector('.menu-tea');
	const menu_dessert = document.querySelector('.menu-dessert');

	if (btn_home) {
		btn_home.addEventListener('click', function() {
			window.location.href = '/main';
		});
	}

	if (menu_coffee) {
		menu_coffee.addEventListener('click', function() {
			window.location.href = '/menu/coffee';
		});
	}

	if (menu_tea) {
		menu_tea.addEventListener('click', function() {
			window.location.href = '/menu/tea';
		});
	}

	if (menu_dessert) {
		menu_dessert.addEventListener('click', function() {
			window.location.href = '/menu/dessert';
		});
	}
});

// 주문 내역을 담을 배열 생성
var orderList = [];

// 주문을 추가하는 함수
function addToOrder(MName, MPrice) {
	var order = {
		MName: MName,
		MPrice: MPrice
	};

	orderList.push(order); // 주문을 배열에 추가
	updateOrderList();    // 주문 내역 업데이트
}

// 주문 내역을 업데이트하는 함수
function updateOrderList() {
  var listSelected = document.querySelector('.list-selected');

  // 기존 내역 삭제
  listSelected.innerHTML = '';

  // 주문 내역 배열을 순회하면서 div 추가
  for (var i = 0; i < orderList.length; i++) {
    var order = orderList[i];
    var orderDiv = document.createElement('div');
    orderDiv.classList.add('order-item'); // 주문 내역 항목에 클래스 추가

    var menuName = document.createElement('span');
    menuName.classList.add('selected-name');
    menuName.innerHTML = order.MName;

    var menuPrice = document.createElement('span');
    menuPrice.classList.add('selected-price');
    menuPrice.innerHTML = order.MPrice;

    var deleteButton = document.createElement('button'); // 삭제 버튼 생성
    deleteButton.innerHTML = '삭제';
    deleteButton.classList.add('delete-button'); // 삭제 버튼에 클래스 추가

    // 삭제 버튼 클릭 이벤트 처리
    deleteButton.addEventListener('click', function() {
      // 해당 주문 항목 삭제
      var itemIndex = Array.from(listSelected.children).indexOf(orderDiv);
      orderList.splice(itemIndex, 1);
      updateOrderList(); // 주문 내역 다시 업데이트
    });

    orderDiv.appendChild(menuName);
    orderDiv.appendChild(menuPrice);
    orderDiv.appendChild(deleteButton); // 삭제 버튼을 주문 내역 div에 추가

    listSelected.appendChild(orderDiv);
  }
}


// 각 <td> 요소에 클릭 이벤트 리스너 추가
var coffeeElements = document.querySelectorAll('td[onclick]');
for (var i = 0; i < coffeeElements.length; i++) {
	coffeeElements[i].addEventListener('click', function() {
		var MName = this.querySelector('span:nth-child(1)').textContent;
		var MPrice = this.querySelector('span:nth-child(2)').textContent;
		addToOrder(MName, MPrice);
	});
}
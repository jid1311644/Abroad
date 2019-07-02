count=0;
function countplus(){
	document.getElementById("collect").className = "btn btn-danger btn-lg wide center";
	count++;
	console.log(count);
	if(count>=4){
		var r = confirm("您最适合的专业是艺术类，查看艺术类强校排行？");
		if (r == true) {
   			window.location.href="arts.jsp";;
		}
	}
}
function changecolor(){
	document.getElementById("collect").className = "btn btn-warning btn-lg wide center";
}

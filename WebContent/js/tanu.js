function allactive(){
	document.getElementById("overall").className = "list-group-item active";
	document.getElementById("price").className = "list-group-item";
	document.getElementById("summary").className = "list-group-item";
}
function priactive(){
	document.getElementById("overall").className = "list-group-item";
	document.getElementById("price").className = "list-group-item active";
	document.getElementById("summary").className = "list-group-item";
	document.getElementById("title").innerHTML="学费水平";
	var parent = document.getElementById("panel");
	var content = document.getElementById("content");
	var image = document.getElementById("image");
	parent.removeChild(content);
	parent.removeChild(image);
	var popCanvas = document.getElementById("priceChart");
	            var barChart = new Chart(popCanvas, {
				  type: 'bar',
				  data: {
				    labels: ["境外学费", "境内学费"],
				    datasets: [{
				      label: '学费（美元）',
				      data: [30910, 30910],
				      backgroundColor: [
				        'rgba(255, 99, 132, 0.6)',
				        'rgba(54, 162, 235, 0.6)',
				        'rgba(0, 0, 0, 0.6)',
				      ]
				    }]
				  }
				});
}
function sumactive(){
	document.getElementById("overall").className = "list-group-item";
	document.getElementById("price").className = "list-group-item";
	document.getElementById("summary").className = "list-group-item active";
	document.getElementById("title").innerHTML="系统评价";
	var parent = document.getElementById("panel");
	//var content = document.getElementById("content");
	//var image = document.getElementById("image");
	var prichart=document.getElementById("priceChart");
	//parent.removeChild(content);
	//parent.removeChild(image);
	parent.removeChild(prichart);
	var popCanvas = document.getElementById("sumChart");
	    var barChart = new Chart(popCanvas, {
			type: 'bar',
			data: {
				labels: ["综合", "师资", "科研", "知名度", "产业", "环境"],
				datasets: [
				{
					label: '综合评分（百分制）',
					data: [75.6, 83.5, 66.8, 79.9, 74.6, 89.3],
					backgroundColor: [
				   	'rgba(255, 159, 64, 0.6)',
				    'rgba(255, 159, 64, 0.6)',
				    'rgba(255, 159, 64, 0.6)',
				    'rgba(255, 159, 64, 0.6)',
				    'rgba(255, 159, 64, 0.6)',
				    'rgba(255, 159, 64, 0.6)',
				    'rgba(255, 159, 64, 0.6)',
					]
				},
				{
				    label: '综合排名',
				    data: [16,56,48,21,67,33],
				    backgroundColor: [
				        'rgba(54, 162, 235, 0.6)',
				        'rgba(54, 162, 235, 0.6)',
				        'rgba(54, 162, 235, 0.6)',
				        'rgba(54, 162, 235, 0.6)',
				        'rgba(54, 162, 235, 0.6)',
				        'rgba(54, 162, 235, 0.6)',
				        'rgba(54, 162, 235, 0.6)',
				    ]
				}]
			}
		});
}
function changecolor(){
	document.getElementById("star").className = "btn btn-primary btn-lg";
}
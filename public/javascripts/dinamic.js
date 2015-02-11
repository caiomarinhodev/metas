$(function(){
	deletarMeta();	
	marcarMeta();
	marcaCheckbox();
});

function deletarMeta(){
	$(".buttonDelete").click(function(){
		var nomeMeta = $(this).attr("id");
		
		$.ajax({
		    url: "/deletarMeta/"+nomeMeta,
		    type: "DELETE"
		}).done(function(){
		    window.location.href = "/";
		});
	});
}

function marcaCheckbox(){
	$(".true").each(function(){
		$(this).find(":checkbox").attr("checked", "true");
	});
}

function marcarMeta(){
	$("table > tbody > tr > td > :checkbox").click(function(){	
	
		var nomeMeta = $(this).attr("value");
						
		$.ajax({
			    url: "/marcarMeta/"+nomeMeta,
			    type: "POST"
			}).done(function(){
			    window.location.href = "/";
			});
	});
}
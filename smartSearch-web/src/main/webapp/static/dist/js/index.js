;(function(){
	var Search = {
		init : function () {
			this.bindEvent();
		},
		bindEvent : function(){
			var _this = this;
			$('#searchBtn').bind('click', function() {
				var keywords = $('#navbarInput-01').val();
				keywords && _this.doSubmit(keywords);
			});
			$('#navbarInput-01').bind('keyup', function(e) {
				var e = e || event,
					code = e.keyCode || e.which;
				code == 13 && $('#searchBtn').click();
			});
		},
		doSubmit : function(keywords){
			$.ajax({
				url : pageConfig.searchUrl + keywords,
				type : 'get',
				dataType : 'json',
				success : function(data){
					console.log(data);
				}
			});
		}
	};
	Search.init();
})();
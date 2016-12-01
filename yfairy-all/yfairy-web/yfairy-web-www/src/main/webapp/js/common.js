(function($) {
	$
			.extend({
				alertSuccess : function(msg) {
					var html = ' <div id="alertSuccessDiv" class="alert alert-success alert-dismissible alert-margin" role="alert" > '
							+ ' <button type="button" class="close" data-dismiss="alert">  '
							+ '	<span aria-hidden="true">&times;</span>  '
							+ '   <span class="sr-only">Close</span>  '
							+ '  </button>  '
							+ ' <span class="text-center" > '
							+ msg + ' </span> ' + ' </div>';
					$("#alertSuccessDiv").remove();
					$("body").prepend(html);
					// 淡出
					$("#alertSuccessDiv").fadeOut(5000);
				},
				alertError : function(msg) {
					var html = ' <div id="alertErrorDiv" class="alert alert-warning alert-dismissible alert-margin" role="alert" > '
							+ ' <button type="button" class="close" data-dismiss="alert">  '
							+ '	<span aria-hidden="true">&times;</span>  '
							+ '   <span class="sr-only">Close</span>  '
							+ '  </button>  '
							+ ' <span class="text-center" > '
							+ msg + ' </span> ' + ' </div>';
					$("#alertErrorDiv").remove();
					$("body").prepend(html);
					// 淡出
					$("#alertErrorDiv").fadeOut(5000);
				},
				isEmpty : function(p) {
					if ("" == p || null == p || undefined == p) {
						return true;
					} else {
						return false;
					}
				},
				isNotEmpty : function(p) {
					if ("" != p && null != p && undefined != p) {
						return true;
					} else {
						return false;
					}
				},
				redirect : function(url) {
					window.location.href = url;
				},
				cusAjax : function(urlp, typep, asyncp, datap, successp, errorp) {
					var type = "post";
					var async = true;
					if ($.isNotEmpty(typep)) {
						type = typep;
					}
					if ($.isNotEmpty(asyncp)) {
						async = asyncp;
					}
					$.ajax({
						url : urlp,
						type : type,
						async : async,
						data : datap,
						success : function(res) {
							successp(res);
						},
						error : function() {
							$.alertError("出现了Ajax请求异常!");
						}
					});
				}
			});
})(jQuery);
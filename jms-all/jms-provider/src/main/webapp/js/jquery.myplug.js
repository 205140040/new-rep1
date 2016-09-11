/*
  插件中的闭包，防止变量冲突
  自定义插件格式如下：
  (function($){
 *插件类容
	})(jQuery);
 */
(function($) {
	/* 插件类容 */
	/* 全局函数 */
	$.extend({
		sayHello : function() {
			alert("hello");
		},
		isEmpty : function(p) {
			if (null == p || "" == p || undefined == p) {
				console.log("p is empty");
				return true;
			} else {
				console.log("p is not empty");
				return false;
			}
		}
	});
	/* 基本方法 */
	$.fn.extend({
		color : function(value) {
			// this 是jquery对象
			this.css("color", value);
		},
		colorDefault : function(options) {
			// 支持默认参数
			var defaults = {
				'color' : 'red',
				'fontSize' : '12px'
			};
			var settings = $.extend(defaults, options);
			return this.css({
				"color" : settings.color,
				"font-size" : settings.fontSize
			});
		}
	});

})(jQuery);

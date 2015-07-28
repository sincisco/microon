<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>完整demo</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="../../js-lib/bootstrap/css/bootstrap.css"></link>
<script type="text/javascript" charset="utf-8"
	src="../../js-lib/jquery/jquery.js"></script>
<script type="text/javascript" charset="utf-8"
	src="../../ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="../../ueditor/ueditor.all.min.js">
	
</script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="../../ueditor/lang/zh-cn/zh-cn.js"></script>

<style type="text/css">
div {
	width: 100%;
}
</style>
</head>
<body>
	<div style="width: 80%; margin: 20px auto;">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">发布文章</h3>
			</div>
			<div class="panel-body">

				<form>
				
					<div class="form-group">
						<label for="articleTitle">文章标题</label> <input
							type="text" class="form-control" id="articleTitle" value="${article.title}"
							placeholder="文章标题">
					</div>
					<div class="form-group">
						<label for="articleOutline">概述</label>
						<textarea id="articleOutline" class="form-control" rows="3" placeholder="文章概述">${article.outline}</textarea>
					</div>
					<script id="editor" type="text/plain"
									style="width: 100%; height: 500px;"></script>
									<br>
					<input type="hidden" id="articleId" value="${article.id}"/>
					<button id="submitButton"  class="btn btn-default">提交</button>
				</form>

			</div>
			
		</div>


	</div>

	

	<script type="text/javascript">
		//实例化编辑器
		//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
		var ue = UE.getEditor('editor');

		$("#submitButton").click(function (event) {
			 event.preventDefault(); 
			 event.stopPropagation();    //阻止 <span> 的 click 事件冒泡  
			var obj={
					id:$("#articleId").val(),
					content : UE.getEditor('editor').getContent(),
					title : $("#articleTitle").val(),
					outline:$("#articleOutline").val()
				};
			var jqxhr = $.post("../updateArticle.do", obj, function() {
				console.log("success");
			}).success(function() {
				console.log("second success");
			}).error(function() {
				console.log("error");
			}).complete(function() {
				console.log("complete");
			});

		});
		
		function isFocus(e) {
			alert(UE.getEditor('editor').isFocus());
			UE.dom.domUtils.preventDefault(e)
		}
		function setblur(e) {
			var editor = UE.getEditor('editor');
			UE.getEditor('editor').blur();
			UE.dom.domUtils.preventDefault(e)
		}
		function insertHtml() {
			var value = prompt('插入html代码', '');
			UE.getEditor('editor').execCommand('insertHtml', value)
		}
		function createEditor() {
			enableBtn();
			UE.getEditor('editor');
		}
		function getAllHtml() {
			alert(UE.getEditor('editor').getAllHtml());
			console.log(UE.getEditor('editor').getAllHtml());
		}
		function getContent() {
			var arr = [];
			arr.push("使用editor.getContent()方法可以获得编辑器的内容");
			arr.push("内容为：");
			arr.push(UE.getEditor('editor').getContent());
			var obj={
					id:$("#articleId").val(),
					content : UE.getEditor('editor').getContent(),
					title : $("#articleTitle").val(),
					outline:$("#articleOutline").val()
				};
			var jqxhr = $.post("../updateArticle.do", obj, function() {
				console.log("success");
			}).success(function() {
				console.log("second success");
			}).error(function() {
				console.log("error");
			}).complete(function() {
				console.log("complete");
			});
			return false;
		}
		function getPlainTxt() {
			var arr = [];
			arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
			arr.push("内容为：");
			arr.push(UE.getEditor('editor').getPlainTxt());
			alert(arr.join('\n'))
		}
		function setContent(isAppendTo) {
			var arr = [];
			arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
			UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
			alert(arr.join("\n"));
		}
		function setDisabled() {
			UE.getEditor('editor').setDisabled('fullscreen');
			disableBtn("enable");
		}

		function setEnabled() {
			UE.getEditor('editor').setEnabled();
			enableBtn();
		}

		function getText() {
			//当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
			var range = UE.getEditor('editor').selection.getRange();
			range.select();
			var txt = UE.getEditor('editor').selection.getText();
			alert(txt)
		}

		function getContentTxt() {
			var arr = [];
			arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
			arr.push("编辑器的纯文本内容为：");
			arr.push(UE.getEditor('editor').getContentTxt());
			alert(arr.join("\n"));
		}
		function hasContent() {
			var arr = [];
			arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
			arr.push("判断结果为：");
			arr.push(UE.getEditor('editor').hasContents());
			alert(arr.join("\n"));
		}
		function setFocus() {
			UE.getEditor('editor').focus();
		}
		function deleteEditor() {
			disableBtn();
			UE.getEditor('editor').destroy();
		}
		function disableBtn(str) {
			var div = document.getElementById('btns');
			var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
			for (var i = 0, btn; btn = btns[i++];) {
				if (btn.id == str) {
					UE.dom.domUtils.removeAttributes(btn, [ "disabled" ]);
				} else {
					btn.setAttribute("disabled", "true");
				}
			}
		}
		function enableBtn() {
			var div = document.getElementById('btns');
			var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
			for (var i = 0, btn; btn = btns[i++];) {
				UE.dom.domUtils.removeAttributes(btn, [ "disabled" ]);
			}
		}

		function getLocalData() {
			alert(UE.getEditor('editor').execCommand("getlocaldata"));
		}

		function clearLocalData() {
			UE.getEditor('editor').execCommand("clearlocaldata");
			alert("已清空草稿箱")
		}
	</script>
</body>
</html>
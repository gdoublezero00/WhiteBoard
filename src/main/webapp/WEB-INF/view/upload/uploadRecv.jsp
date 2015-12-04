<%@page contentType="text/html; charset=utf-8" %>
<!doctype html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<title></title>
	<script src="/assets/components/webcomponentsjs/webcomponents-lite.min.js"></script>
	<link rel="stylesheet" href="/assets/css/face.css" />
	<!--<link rel="import" href="/assets/components/iron-component-page/iron-component-page.html" /> -->
	<link rel="import" href="/assets/components/iron-icons/iron-icons.html" />
	<link rel="import" href="/assets/components/paper-styles/paper-styles.html" />
	<link rel="import" href="/assets/components/paper-header-panel/paper-header-panel.html" />
	<link rel="import" href="/assets/components/paper-input/paper-input.html" />
	<link rel="import" href="/assets/components/paper-button/paper-button.html" />
	<link rel="import" href="/assets/components/paper-icon-button/paper-icon-button.html" />
</head>
<body class="fullbleed layout vertical">
<paper-header-panel class="flex" mode="seamed">
	<paper-toolbar>
		<div>upload</div>
	</paper-toolbar>
	<form is="iron-form" id="form" action="./upload-recv" method="post" enctype="multipart/form-data">
		<paper-icon-button icon="file-upload" on-tap="{{ a }}"></paper-icon-button>
		<paper-input type="text" name="test"></paper-input>
		<input type="file" name="file" />
		<input type="submit" value="send" />
	</form>
</paper-header-panel>

</body>

</html>

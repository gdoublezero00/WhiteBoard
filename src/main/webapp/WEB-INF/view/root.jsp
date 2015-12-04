<!doctype html>

<html lang="ja">
	<head>
		<link rel="stylesheet" href="/assets/components/material-design-lite/material.min.css"></script>
		<script src="/assets/components/material-design-lite/material.min.js"></script>
		<script src="/assets/components/react/react.min.js"></script>
		<script src="/assets/components/react/JSXTransformer.js"></script>
		<script src="/assets/components/jquery/dist/jquery.min.js"></script>
	</head>

	<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<header class="mdl-layout__header">
			<div class="mdl-layout__header-row">
			<span class="mdl-layout-title">title</span>	
		</div>
		</header>
		<main class="mdl-layout__content">
			<div class="mdl_grid">
				<div class="mdl-cell mdl-cell--12-col" id="content"></div>
			</div>
		</main>
	</div>

	<script type="text/jsx">
		var ImageBox = React.createClass({
			render: function() {
				return (
					<div className="re">
					</div>
				);
			}
		});
		React.render(
			<ImageBox />,
			document.getElementById("content")
		);
	</script>
	</body>
</html>

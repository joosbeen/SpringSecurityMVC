app.controller("reportusersCtrl", function($scope, $http) {

	$scope.typevo = [];
	$scope.typevo = {
		users:"",
		type: ""
	};

	$scope.generar_report_users = function(users,tipo) {

		$scope.typevo.users = users;
		$scope.typevo.type = tipo;
		$scope.imagencargandovisible = true;
		$scope.mensajeimagencargandovisible = "";
		$("#myModalGenerandoReporte").modal("show");

		$http({
			method: "POST",
			url: "services/users/reporte/users.json",
			data: $scope.typevo
		}).then(function mySuccess(response) {
			$scope.imagencargandovisible = false;
			if (response.data.estado) {
				$scope.mensajeimagencargandovisible = "Reporte guardado en descarga!";
			} else {
				$scope.mensajeimagencargandovisible = "Ocurrio un error inesperado, intento en unos minutos.";
			}
			//var fileURL = URL.createObjectURL(data);
			//window.open(fileURL);
		}, function myError(response) {
			$scope.imagencargandovisible = false;
			$scope.mensajeimagencargandovisible = "Ocurrio un error en el servidor!";
		});
	};

});
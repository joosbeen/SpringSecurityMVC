app.controller("adminUsuarioCtrl", function($scope, $http) {

	$scope.usuario = [];
	$scope.usuario = {
		user_ID: 0,
		username: "",
		password: "",
		enabled: false,
		nombre: "",
		apellidos: "",
		fecha_NACIMIENTO: "",
		sexo: 'H',
		fecha_ALTA: "",
		fecha_MODIFICACION: "",
		huso_HORARIO: "",
		correo_ELECTRONICO_PPAL: "",
		tracking: false
	};

	$scope.alert_visible = false;
	$scope.action_add_update = ""; // add , update
	$scope.fecha_NACIMIENTO_dos = "";

	$scope.authority_list = [];
	$scope.authority_list = {
		authority: "",
		description: ""
	};

	$scope.role = "";

	$scope.lista_Authorities = function() {

		$http({
			method: "GET",
			url: "services/authority/list.json",
			headers: 'application/json'
		}).then(function mySuccess(response) {
			$scope.authoritys = response.data;
		}, function myError(response) {
			alert("ERROR:" + response.statusText);
		});

	};

	$scope.obtener_descripcion_role = function() {
		$scope.descriccion_authority = role.description;
	};

	$scope.lista_usuarios = function() {

		$http({
			method: "GET",
			url: "services/users/list.json",
			headers: 'application/json'
		}).then(function mySuccess(response) {
			$scope.usuarios = response.data;
		}, function myError(response) {
			alert("ERROR:" + response.statusText);
		});

	};

	$scope.lista_usuarios();

	$scope.status_usuarios = function(user) {
		$http({
				method: "POST",
				url: "services/users/status.json",
				headers: 'application/json',
				data: user
			})
			.then(
				function mySuccess(response) {
					if (response.data.estado) {
						$scope.lista_usuarios();
					} else {
						$scope.mensajeModalErrorBackground = '#E36A6A';
						$scope.mensajeModalErrorTitulo = response.data.tipo;
						$scope.mensajeModalErrorMensaje = response.data.mensaje;
						$("#myModalMensajeAlert")
							.modal("show");
					}
				},
				function myError(response) {
					$scope.mensajeModalErrorBackground = '#E36A6A';
					$scope.mensajeModalErrorTitulo = response.status;
					$scope.mensajeModalErrorMensaje = response.statusText;
					$("#myModalMensajeAlert").modal(
						"show");
				});

	};

	$scope.estado_boolean_a_string = function(estado) {
		if (estado) {
			return "Activo";
		}
		return "Inactivo";
	};

	$scope.estado_color_boton = function(estado) {
		if (estado) {
			return "btn-success";
		}
		return "btn-danger";
	};

	$scope.f_action_add_update = function(action, user) {

		$scope.lista_Authorities();

		if (action == "update") {
			$scope.usuario = user;
			$scope.tituloModalUsuario = "Editar Usuario";
		} else {
			$scope.tituloModalUsuario = "Agregar Usuario";

		}
		$scope.action_add_update = action;
	};

	$scope.sexo_usuario_define = function(sexo) {
		$scope.usuario.sexo = sexo;
	};

	$scope.guardar_fecha_nacimiento = function() {
		var fecha = new Date(document.getElementById("fecha_nac").value);
		var dia = (fecha.getMonth() + 1);

		if ((fecha.getMonth() + 1) < 10) {
			dia = "0" + (fecha.getMonth() + 1);
		}
		$scope.usuario.fecha_NACIMIENTO = fecha.getFullYear() +
			"-" + dia + "-" + (fecha.getDate() + 1);
	};

	$scope.asignar_role_usuario = function(role) {
		$scope.authority_list = role;
	};

	$scope.registrar_actualizar_usuario = function() {

		if ($scope.validar_campos_usuarios()) {

			$http({
					method: "POST",
					url: "services/users/" + $scope.action_add_update + ".json",
					headers: 'application/json',
					data: $scope.usuario
				})
				.then(function mySuccess(response) {
					if (response.data.estado) {
						$("#myModal").modal("hide");
						$scope.lista_usuarios();
						$scope
							.agregar_roles_usuarios();
					} else {
						$scope.alert_visible = true;
						$scope.mensaje_campo_invalido = response.data.mensaje;
					}
				}, function myError(response) {
					alert("ERROR:" +
						response.statusText);
				});
		}
	};

	$scope.agregar_roles_usuarios = function() {
		$http({
				method: "POST",
				url: "services/authorities/add.json",
				headers: 'application/json',
				data: {
					'username': $scope.usuario.username,
					'authority': $scope.authority_list.authority
				}
			})
			.then(
				function mySuccess(response) {
					if (!response.data.estado) {
						$scope.alert_visible = true;
						$scope.mensaje_campo_invalido = " Ocurrio un error:" +
							response.data.mensaje;
					}
				},
				function myError(response) {
					alert("ERROR:" +
						response.statusText);
				});
	};

	$scope.validar_campos_usuarios = function() {
		$scope.alert_visible = false;
		if ($scope.usuario.username == "" ||
			($scope.usuario.username.length < 6 || $scope.usuario.username.length > 25)) {
			return $scope.validar_campos_usuarios_alert("El campo nombre 'NOMBRE DE USUARIO' es obligatorio, [a-z A-Z 0-9] min:6, max:25");
		} else if ($scope.usuario.password == "") {
			return $scope.validar_campos_usuarios_alert("El campo nombre 'PASSWORD'es obligatorio, [a-z A-Z 0-9] min:6, max:12");
		} else if ($scope.usuario.nombre == "") {
			return $scope.validar_campos_usuarios_alert("El campo nombre 'NOMBRE'es obligatorio, [a-z A-Z].");
		} else if ($scope.usuario.apellidos == "") {
			return $scope.validar_campos_usuarios_alert("El campo nombre 'APELLIDOS'es obligatorio, [a-z A-Z].");
		} else if ($scope.usuario.fecha_NACIMIENTO == "") {
			return $scope.validar_campos_usuarios_alert("El campo nombre 'FECHA DE NACIMIENTO' es obligatorio.");
		} else if ($scope.usuario.huso_HORARIO == "") {
			return $scope.validar_campos_usuarios_alert("El campo nombre 'HORA DE USO' es obligatorio.");
		} else if ($scope.usuario.correo_ELECTRONICO_PPAL == "") {
			return $scope.validar_campos_usuarios_alert("El campo nombre 'CORREO' es obligatorio.");
		} else if ($scope.authority_list.authority == "") {
			return $scope.validar_campos_usuarios_alert("El campo nombre 'ROLE' es obligatorio.");
		}
		return true;
	};

	$scope.validar_campos_usuarios_alert = function(campo) {
		$scope.alert_visible = true;
		$scope.mensaje_campo_invalido = campo;
		return false;
	};

});
DECISIONES TOMADAS:
	-Se utiliza toLowerCase() en todas las funciones, para poder generalizar entre strings como "#f1" y "#F1".
	-En la primera consulta, solo se busca que se mencione el apellido, sin incluir el nombre. Esto es debido a que, por ejemplo, se podria encontrar el texto "@max_fernandez ..." y esto contaria como una mencion indeseada.
	-En la segunda consulta, los usuarios aparecen verificados con un 'signo de tick'
	-En la cuarta consulta, ademas de no tener en cuenta el hashtag #f1, tampoco se consideran #F1, ni #formula1 ni #Formula1.
	-En la quinta consulta, se considera a la columna 'user_favourites' del archivo CSV como la cantidad de favourites que recibio el tweet del registro.
	-En la sexta consulta, al igual que la primera consideracion, se utiliza toLowerCase() a la palabra/frase ingresasda por el usuario.
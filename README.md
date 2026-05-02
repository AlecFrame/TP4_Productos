# TP4_Productos
Tp 4 - MVVM Listar y Cargar Productos

El sistema se ejecutó en un Android 15 y posee API minima para 13

Es una aplicación sencilla e intuitiva para ver los productos en una lista y cargarlos.

---

1. Activities:
    * MainActivity: principal encargada de crear y decir como manejar los navegables, pusimos ambos navegables al principio, pero al final solo dejamos el Drawer y al otro lo comentamos.

---

2. Fragments:
    * ListarFragment: Es el fragment de inicio, que contiene un RecycleView para cargar los productos, para ello crea un ProductoAdapter que usa a ProductoHolder para mostrar el item.xml que es una card en cada registro.
    * CargarFragment: Lo usamos como formulario, posee 3 campos para los datos del Producto y un botón para cargarlo.

---

3. Adapter:
    * ProductoAdapter: En su constructor ordenamos la lista que recibe por parámetro alfabéticamente.

---

4. Modelo:
    * Producto: posee código el cual no se repite, descripción y precio el cual no puede ser negativo o 0, también estos datos no pueden estar vacíos.
---

5. ViewModels:
    * CargarViewModel: posee 2 Mutables, un String error y otro Integer color para setear en la vista un texto descriptivo del error en rojo por la verificación sobre campos vacíos o por los anteriormente mencionados, también sirve para mostrar cuando el producto se cargó satisfactoriamente, cambiando su color a verde, también tiene un método que se llama al apretar el botón de Cargar producto en el Fragment.

---

Integrantes del grupo:
* Walter Alexander Vertacnik 46260391
* Stefani Nair Escobar 38752519
* Valentino Coppola 47040879
* Jeremías Sosa 39797677
* Luca Salonia 40722588
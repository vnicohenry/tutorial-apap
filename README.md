# Tutorial APAP
## Authors
* **Nicolas Henry Wijaya** - *1806191566* - *APAP A*

### What I have learned today

### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
> **Issue Tracker** adalah suatu fitur pada GitHub yang memungkinkan kita untuk mengetahui segala perubahan yang terjadi pada repository kita, seperti penambahan atau pengurangan kode, pembetulan bugs, dll.
2. Apa perbedaan dari git merge dan git merge --squash?
> **Git merge** adalah perintah untuk menggabungkan branch dengan master. Commit yang ada di branch juga akan digabungkan satu persatu ke dalam master. Sedangkan **git merge --squash** adalah perintah untuk menggabungkan seluruh commit dalam branch untuk digabung menjadi satu commit besar dan digabungkan kedalam master. Perintah ini dapat digunakan ketika ada beberapa commit yang terlihat tidak jauh berbeda.
3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?
> Ada banyak keuntungan dari menggunakan **Version Control System** seperti git. Salah satunya adalah pengembangan aplikasi yang dikerjakan bersama-sama dapat dilakukan secara paralel tanpa harus menunggu suatu fitur diselesaikan. Hal ini dapat dilakukan dengan fitur branch dan merge yang git punya.
### Spring
4. Apa itu library & dependency?
> **Library** merupakan sekumpulan fungsi atau kode yang digunakanan di berbagai proyek untuk melayani suatu tujuan tertentu. Sedangkan **dependency** merupakan ketergantungan atau keterikatan antara satu kelas dengan kelas yang lain.
5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
> Saat bekerja dalam tim, ada banyak aktivitas yang harus diseragamkan, misalnya struktur folder, penggunaan library serta workflow. Keseragaman ini harus ditentukan dan diberlakukan pada seluruh project, agar programmer tidak kesulitan ditugaskan di project manapun. **Maven** mempunyai aturan-aturan yang mempermudah proses pengerjaan sebuah project terlebih pada project yang besar. Dengan menggunakan Maven,  kita tidak perlu membuat aturan sendiri, cukup mempelajari dan mengikuti aturan yang sudah dibuat maka jenis aplikasi apapun akan memiliki struktur yang sama. Maven juga sudah dikenali oleh banyak editor, seperti Netbeans, Eclipse, IntelliJ IDEA. Beberapa alternatif selain Maven yaitu Ant + Ivy dan Gradle.
6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
> Selain untuk pengembangan web, **Spring Framework** juga digunakan untuk mengembangkan aplikasi enterprise yang skalanya lebih besar, manajemen transaksi, akses data, messaging, pengujian, termasuk juga aplikasi pada ranah keamanan dan big data. Selain itu, Spring juga dapat dikembangkan untuk aplikasi web berbasis MVC dan webservice framework RESTful.
7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan
@RequestParam atau @PathVariable?
> **@PathVariable** berfungsi untuk mengekstrak nilai dari URI. Sedangkan **@RequestParam** berfungsi untuk mendapatkan parameter dari URI yang biasa dikenal sebagai parameter query. **@RequestParam** dapat dipakai pada aplikasi web tradisional dimana data sebagaian besar diteruskan dalam query sementara, sedangkan **@PathVariable** lebih berguna untuk layanan web dengan framework RESTful dimana URL berisi nilai-nilai.

### What I did not understand
- [] Kenapa saya harus menggunakan Thymeleaf?
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


### What I have learned today (1 Oct 2020)

1. Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:
`http://localhost:8080/hotel/addidHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom&noTelepon= 081xxx`
> Terjadi error **Whitelabel Error Page** karena template _add-hotel.html_ yang di-_return_ belom dibuat

2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat
> Notasi @Autowired merupakan implementasi dari konsep ***Dependency Injection***. Dengan menggunakan @Autowired kita tidak perlu lagi mendefinisikan method getter, setter, dan constructor. Semua field/property yang diberikan notasi tersebut akan diisikan oleh Spring dengan object bertipe-data sesuai.

3. Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:
`http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom`
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
> Terjadi error **Whitelabel Error Page** karena ada satu parameter yang tidak diberikan yaitu No Telepon.

4. Jika Papa APAP ingin melihat Hotel dengan nama Papa APAP, link apa yang harus diakses?
> Link yang harus diakses adalah `http://localhost:8080/hotel/view?idHotel=1`

5. Tambahkan 1 contoh Hotel lainnya sesukamu. Lalu cobalah untuk mengakses:
`http://localhost:8080/hotel/viewall`
apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
> ![ss apap](https://user-images.githubusercontent.com/45789642/94834929-3abd5400-043b-11eb-829d-beb1336e089d.png)

### What I did not understand
- Perbedaan @Requestmapping dan @Getmapping
> Perbedaannya adalah jika requestmapping akan menerima parameter yang masuk dan akan routing sesuai parameter yang ditulis.

### What I have learned today (9 Oct 2020)

1. Pada _class_ `KamarDb`, terdapat _method_ `findAllByHotelId` , apakah kegunaan dari method tersebut?
> _Method_ tersebut digunakan untuk mencari semua `Kamar` pada suatu `Hotel` yang sama berdasarkan ID `Hotel` tersebut

2. Pada _class_ `HotelController` , jelaskan perbedaan _method_ `addHotelFormPage` dan `addHotelSubmit` ?
> _Method_ `addHotelFormPage` digunakan untuk menampilkan _form_ untuk menambahkan hotel baru dimana _form_ tersebut digunakan untuk mengisi data-data terkait pembuatan hotel. Sedangkan _method_ `addHotelSubmit` adalah method yang untuk memproses data-data yang diinput sebelumnya dengan memasukkannya ke dalam _database_ `hotelDB`

3. Jelaskan kegunaan dari JPA Repository !
> __JPa Repository__ merupakan sebuah modul yang disediakan oleh Spring, dimana modul ini secara umum digunakan untuk aktivitas terkait _database_ dan _datastore_ pada project yang sedang dibangun. Dengan JPA Repository kita dapat membuat __repository interface__ untuk setiap _domain entity_ pada aplikasi.

4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara HotelModel dan KamarModel dibuat?
> Kode tersebut berada pada _class_ `kamarModel` tepatnya pada potongan kode seperti di bawah ini:
```java
@ManyToOne(fetch=FetchType.EAGER, optional = false)
@JoinColumn(name="hotelId", referencedColumnName = "id", nullable = false)
@OnDelete(action=OnDeleteAction.CASCADE)
@JsonIgnore
private HotelModel hotel;
```
>Maksud dari `@ManyToOne` adalah ada banyak object `Kamar` yang bisa berelasi dengan satu object `Hotel`, dengan kata lain satu Hotel dapat memiliki banyak Kamar.


5. Jelaskan kegunaan `FetchType.LAZY`, `CascadeType.ALL` , dan `FetchType.EAGER`!
> - `FetchType.LAZY` digunakan oleh suatu objek untuk me-_load_ objek yang berelasi dengannya saat dipanggil saja (_on-demand_).
>- `FetchType.EAGER` digunakan oleh suatu objek untuk me-_load_ objek yang berelasi dengannya bersamaan saat objek tersebut me-_load_ semua atributenya
>- `CascadeType.ALL` memungkinkan kita untuk menggunakan semua operasi dari `EntityManager` yaitu `PERSIST, REMOVE, REFRESH, DETACH` pada semua objek yang berelasi pada objek tersebut.

### What I did not understand
- [ ] Gimana caranya bisa otomatis _increase_ ID Hotel dan nomor Kamar?
- [ ] Gimana caranya bisa auto update / add tanpa perlu bikin object?

### What I have learned today (15 Oct 2020)

1. Jelaskan perbedaan `th:include` dan `th:replace`!
> `th:include` digunakan jika kita mau mengikutsertakan suatu konten ke dalam suatu tag pada html. Sedangkan, `th:replace` digunakan untuk mengganti keseluruhan isi tag dengan konten tersebut.

2. Jelaskan apa fungsi dari th:object!
> `th:object` berfungsi untuk mengambil sebuah object secara utuh beserta attribute-attribute yang dimiliki. Misalya kita mengambil _instance_ dari object `Buku` dengan cara `th:object="${buku}"`. Object ini memiliki atribut `judul`, `penulis`, `tahun terbit` dan kita ingin mengambil `judul` dari buku tersebut dapat dilakukan dengan `th:text="*{judul}"`. Hasilnya akan sama dengan `th:text="${buku.judul}"`.

3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
> Asterisk (`*`) dan dollar (`$`) sama-sama digunakan sebagai _Variable expressions_. Perbedaannya adalah Asterisk akan memanggil attribut dari _selected object_, tetapi jika tidak ada object yang dipilih, maka penggunaan asterisk dan dollar akan sama. 

4. Bagaimana kamu menyelesaikan latihan nomor 3?
> Pada file `fragment.html` yang sebelumnya dibuat, saya menambahkan kondisi (_if-else_) pada kode _navbar_ yang akan menyesuaikan dengan url yang sedang ditampilkan pada saat itu. Detail kodenya seperti di bawah ini:
```html
<div class="navbar-nav ml-auto">
	<a th:if="${#httpServletRequest.requestURI == '/'}" class="nav-item nav-link active" th:href="@{/}">Home<span class="sr-only">(current)</span></a>
	<a th:if="${#httpServletRequest.requestURI == '/hotel/view'}" class="nav-item nav-link active" th:href="@{/}">View Hotel<span class="sr-only">(current)</span></a>
	<a th:if="${#httpServletRequest.requestURI == '/hotel/change'}" class="nav-item nav-link active" th:href="@{/}">Update Hotel<span class="sr-only">(current)</span></a>
	<a th:if="${#httpServletRequest.requestURI == '/hotel/add'}" class="nav-item nav-link active" th:href="@{/}">Add Hotel<span class="sr-only">(current)</span></a>
	<a th:if="${#httpServletRequest.requestURI == '/hotel/view-all'}" class="nav-item nav-link active" th:href="@{/}">View All Hotel<span class="sr-only">(current)</span></a>
	<a th:if="${#httpServletRequest.requestURI == '/kamar/add'}" class="nav-item nav-link active" href="#">Add Kamar<span class="sr-only">(current)</span></a>
	<a th:if="${#httpServletRequest.requestURI == '/kamar/change'}" class="nav-item nav-link active" th:href="@{/}">Update Kamar<span class="sr-only">(current)</span></a>
</div>
```

### What I understand
- Perlu adanya `params` sebagai _router_ jika kita ingin melakukan banyak perintah pada halaman yang sama.


### What I have learned today (19 Nov 2020)

1. Apa itu Postman? Apa kegunaannya?
> Postman merupakan _tools_ yang dapat digunakan untuk membantu pembuatan dan _testing_ **RESTful API**. Dengan menggunakan Postman, _developer_ tidak harus membuat semua code secara penuh untuk mengetahui _response_ dari API yang dibuat sehingga dapat mempercepat dan mempermudah proses _testing_ fungsionalitas dari API. Developer hanya perlu memasukan address yang ingin dituju beserta pilihan _response_ yang diinginkan, maka Postman akan menampilkan _response_ tersebut.

2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty!
> `@JsonIgnoreProperties` adalah anotasi yang digunakan untuk menekan serialisasi dari _properties_ pada saat _serialization_, atau meng-_ignore_ _processing_ dari JSON _properties_ pada saat serialization, atau meng-ignore processing dari JSON _properties_. Jika _field_ tersebut tidak terisi, _field_ JSON tersebut akan diabaikan dan tidak ada error yang dilemparkan. Sedangkan `@JsonProperty` merupakan anotasi yang berfungsi untuk mengubah nama variabel. `@JsonProperty` memberitahu Jackson ObjectMapper untuk memetakan nama property JSON ke bidang Java yang dianotasi.

3. Apa kegunaan atribut WebClient?
> `WebClient` merupakan _interface_ yang disediakan oleh Spring Framework yang berfungsi untuk poin akses utama dari web / HTTP requests. `WebClient` berfungsi untuk menginstansiasi sebuah akses poin URL serta mengelola request dan response atas URL tersebut

4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
> `ResponseEntity` digunakan untk merepresentasikan keseluruhan dari HTTP _Response_ yang mencangkup _status code_, _headers_, dan _body_. `ResponseEntity` dapat digunakan untuk melakukan konfigurasi pada HTTP _Response_. Sedangkan `BindingResult` merupakan sebuah _interface_ yang menyimpan hasil dari validasi maupun error yang ada. `BindingResult` perlu digunakan setelah `@Valid` untuk menampung hasil dari validasi.

### What I have learned today (26 Nov 2020)

1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi ! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?
> `Otentikasi` merupakan proses untuk memverifikasi siapa pengguna yang sedang berusaha untuk mengakses suatu program / _website_. Contoh pada tutorial adalah saat verifikasi user yang ingin login, kode ini berada file `UserDetailsServiceImpl.java`. Berikut adalah cuplikan kodenya:
![image](https://user-images.githubusercontent.com/45789642/100362342-df1fd900-302d-11eb-93b6-166a2fed5764.png)
Sedangkan `Otorisasi` merupakan proses pemberian akses terhadap pengguna tertentu. Contoh pada tutorial adalah pembatasan akses untuk **add kamar** yang hanya bisa dilakukan oleh _role_ `RECEPTIONIST`. Berikut adalah cuplikan kodenya:
![image](https://user-images.githubusercontent.com/45789642/100362780-6ec58780-302e-11eb-880b-4770e4c32a4f.png)

2. Apa itu BCryptPasswordEncoder ? Jelaskan secara singkat cara kerja dan tujuannya.
> `BCryptPasswordEncoder` adalah fitur yang disediakan oleh Spring Boot sebagai mekanisme keamanan untuk mengenkripsi password sehingga tidak mudah terbaca oleh manusia dan sistem. Proses ini menggunakan algoritma `"one-way-hashing"` atau pengenkripsian satu arah, yang artinya ketika password sudah dienkripsi, maka tidak dapat lagi dikembalikan ke bentuk semula atau didekripsi.

3. Jelaskan secara singkat apa itu UUID beserta penggunaannya!
> `UUID` merupakan singkatan dari `Universally Unique Identifiers`, adalah angka 128 bit, yang terdiri dari 16 octets dan direpresentasikan dalam 32 base-16 karakter. UUID digunakan untuk mengidentifikasikan informasi pada sebuah sistem. UUID bersifat unique dan memiliki kemungkinan duplikasi yang rendah. Maka dari itu, UUID berguna sebagai _associative keys_ pada _database_. UUID dapat digenerate secara independent dan dapat digunakan pada seluruh sistem tanpa khawatir adanya duplikasi.

4. Apa kegunaan class UserDetailsServiceImpl.java ? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java ?
> `UserDetailsServiceImpl` secara umum digunakan untuk proses identifikasi user serta proses otentikasi dan otorisasi user. Class tersebut dibutuhkan secara khusus karena dapat berfungsi dalam hal **security**, sedangkan class `UserRoleServiceImpl` hanya berhubungan dengan operasi yang melibatkan _database_ saja.

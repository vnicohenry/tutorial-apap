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

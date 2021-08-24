# trên class
```
Khi khai báo Transactional trên class.
 Tất cả method là public khi khi được gọi từ bên ngoài thì đều sẽ tạo và sử dụng config transaction của class.
```
# trên method
```
nếu chúng ta config Transactional ở trên method. Transactional ở trên method sẽ overriding Transactional trên class
Khi đó config Transactional ở trên method sẽ được sử dụng
```

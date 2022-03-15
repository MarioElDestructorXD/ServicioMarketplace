package mx.edu.utez.marketplace.product.controller;

import mx.edu.utez.marketplace.product.model.Product;
import mx.edu.utez.marketplace.product.model.ProductImage;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = {"*"})
public class ProductController{
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll ()  {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById (@PathVariable ("id") long id)  {
        return productService.findById(id);
    }

    @PostMapping ("/")
    public ResponseEntity<Message>  save (@RequestBody ProductDTO productDTO)  {

        List<ProductImage> images = new ArrayList<>();

        productDTO.getImages().forEach(image -> images.add(new ProductImage(image.getName(),image.getFileBase64(),null)));

        Product product = new Product(productDTO.getName(),productDTO.getDescription(),productDTO.getPrice(),productDTO.getQuantity(),productDTO.getBrand(),productDTO.getStatus(),productDTO.getSubcategory(),images);

        return productService.save(product);
    }

    @PutMapping ("/")
    public ResponseEntity<Message> update (@RequestBody ProductDTO productDTO){

        Product product = new Product(productDTO.getName(),productDTO.getDescription(),productDTO.getPrice(),productDTO.getQuantity(),productDTO.getBrand(),productDTO.getStatus(),productDTO.getSubcategory(),null);

        return productService.update(product);
    }
}

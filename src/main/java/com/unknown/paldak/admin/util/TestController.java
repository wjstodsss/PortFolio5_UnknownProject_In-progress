package com.unknown.paldak.admin.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/productDetails")
    public String getProductDetails(Model model) {
        // Product 객체 생성
        Product product = new Product();
        product.setProductId("12345");
        product.setProductName("Product X");
        product.setDescription("This is a product description.");
        product.setPrice("$99.99");

        // 가변적인 변수들을 저장하는 컬렉션을 생성하고 데이터 추가
        List<AdditionalVariable> additionalVariables = new ArrayList<>();

        // 이미지 출력 변수 추가
        AdditionalVariable imageVar = new AdditionalVariable("Product Image", "path_to_image.jpg", "image", "Product Image", "");
        additionalVariables.add(imageVar);

        // 인풋 태그 출력 변수 추가
        AdditionalVariable inputVar = new AdditionalVariable("Product Name", "Product X", "input", "","productName");
        additionalVariables.add(inputVar);

        // JSP로 데이터 전달
        model.addAttribute("product", product);
        model.addAttribute("additionalVariables", additionalVariables);

        // JSP 파일 이름 반환
        return "admin/test/get";
    }
	
	public class Product {
	    private String productId;
	    private String productName;
	    private String description;
	    private String price;
		public String getProductId() {
			return productId;
		}
		public void setProductId(String productId) {
			this.productId = productId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}

	}

	public class AdditionalVariable {
	    private String label;
	    private String value;
	    private String type;
	    private String altText;
	    private String name;

	    public AdditionalVariable(String label, String value, String type, String altText, String name) {
	        this.label = label;
	        this.value = value;
	        this.type = type;
	        this.altText = altText;
	        this.name = name;
	    }

		public String getLabel() {
			return label;
		}

		public String getValue() {
			return value;
		}

		public String getType() {
			return type;
		}

		public String getAltText() {
			return altText;
		}
		
		public String getName() {
			return name;
		}

	    
	}
}




//package com.vending.controllers;
//package com.vending.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.vending.exception.ResourceNotFoundException;
//import com.vending.model.Login;
//import com.vending.model.Order;
//import com.vending.model.OrderRepository;
//import com.vending.model.Vending;
//import com.vending.model.VendingRepository;
//
//@CrossOrigin(origins="http://localhost:4200")
//
//@Controller
////@RestController
////@RequestMapping("/api/v1")
//public class VendingController {
//    @Autowired
//    private VendingRepository vendingRepository;
//    private OrderRepository orderRepository;
//
//    @GetMapping("/login")
//    public String logingPage(Model model)
//    {
//    	Login login = new Login();
//    	model.addAttribute("log", login);
//    	
//    	return "login";
//    }
//	
//	@GetMapping("/")
//    public List<Vending> viewHomePage() {
////        return "index";
//        return vendingRepository.findAll();
//
//	}
//    
////    @GetMapping("/vendings")
////    public List<Vending> getAllVendings() {
////        return vendingRepository.findAll();
////    }
//
//    @GetMapping("/vendings/{id}")
//    public ResponseEntity<Vending> getVendingsById(@PathVariable(value = "id") Long vendingId)
//        throws ResourceNotFoundException {
//        Vending vending = vendingRepository.findById(vendingId)
//          .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + vendingId));
//        return ResponseEntity.ok().body(vending);
//    }
//    
//    @PostMapping("/vendings1")
//    public Vending createVending( @RequestBody Vending vending) {
//        return vendingRepository.save(vending);
//    }
//
//    @PutMapping("/vendings/{id}")
//    public ResponseEntity<Vending> updateVending(@PathVariable(value = "id") Long vendingId,
//         @RequestBody Vending vendingDetails) throws ResourceNotFoundException {
//        Vending vending = vendingRepository.findById(vendingId)
//        .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + vendingId));
//
//        
//    	vending.setTea(vendingDetails.getTea());
//    	vending.setCoffee(vendingDetails.getCoffee());
//    	vending.setSugar(vendingDetails.getSugar());
//    	vending.setWater(vendingDetails.getWater());
//    	vending.setMilk(vendingDetails.getMilk());
//
//        final Vending updatedVending = vendingRepository.save(vending);
//        return ResponseEntity.ok(updatedVending);
//    }
////
////    @DeleteMapping("/vendings/{id}")
////    public Map<String, Boolean> deleteVending(@PathVariable(value = "id") Long vendingId)
////         throws ResourceNotFoundException {
////        Vending vending = vendingRepository.findById(vendingId)
////       .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + vendingId));
////
////        vendingRepository.delete(vending);
////        Map<String, Boolean> response = new HashMap<>();
////        response.put("deleted", Boolean.TRUE);
////        return response;
////    }
//    
//    @PutMapping("/orders")
////    public Order orders( @RequestBody Order order )
//    public String orders(@ModelAttribute("Orders") Order order)
//    {
//
////    	Get data from storage how many purchased before and add orders number to set total number.
//    	order.setTea(order.getTea());
//    	order.setBlackTea(order.getBlackTea());
//    	order.setCoffee(order.getCoffee());
//    	order.setBlackCoffee(order.getBlackCoffee());
////    	return orderRepository.save(order);
////		orderRepository.save(order);
//		return "redirect:/";
//    }
//    
//}

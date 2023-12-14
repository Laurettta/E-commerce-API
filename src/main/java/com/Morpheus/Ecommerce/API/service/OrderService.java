package com.Morpheus.Ecommerce.API.service;

import com.Morpheus.Ecommerce.API.dto.OrderItemDTO;
import com.Morpheus.Ecommerce.API.dto.OrderRequestDTO;
import com.Morpheus.Ecommerce.API.dto.OrderResponseDTO;
import com.Morpheus.Ecommerce.API.model.Customer;
import com.Morpheus.Ecommerce.API.model.Order;
import com.Morpheus.Ecommerce.API.model.OrderItem;
import com.Morpheus.Ecommerce.API.model.Product;
import com.Morpheus.Ecommerce.API.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;
    private final CustomerService customerService;
    private final ProductService productService;

    public Object createOrder(OrderRequestDTO orderDTO) {

        Customer customer = customerService.getCustomer(orderDTO.getCustomerId());


        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(orderDTO.getProducts().stream().mapToDouble(OrderItemDTO::getSubtotal).sum());

        Order savedOrder = orderRepository.save(order);

        order.setCustomer(customer);

        ArrayList<OrderItem> orderItems = createOrderItems(orderDTO.getProducts(), savedOrder);

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setCustomerId(customer.getId());
        orderResponseDTO.setOrderDate(LocalDateTime.now());
        orderResponseDTO.setTotalAmount(savedOrder.getTotalAmount());
        orderResponseDTO.setOrderItems(orderItems);


        return orderResponseDTO;
    }

    public ArrayList<OrderItem> createOrderItems(ArrayList<OrderItemDTO> orderItemDTOs, Order order) {

        List<OrderItem> orderItems = orderItemDTOs.stream().map((OrderItemDTO orderItemDTO) -> {
            Product product = productService.getProductById(orderItemDTO.getProductId());
            return orderItemService.createOrderItem(orderItemDTO, product, order);
        }).toList();

        return new ArrayList<>(orderItems);
    }

}

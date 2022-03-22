package com.rasmoo.client.raspay.service.impl;

import com.rasmoo.client.raspay.dto.PaymentDto;
import com.rasmoo.client.raspay.exception.BusinessException;
import com.rasmoo.client.raspay.exception.NotFoundException;
import com.rasmoo.client.raspay.mapper.CreditCardMapper;
import com.rasmoo.client.raspay.model.CreditCardModel;
import com.rasmoo.client.raspay.repository.CreditCardRepository;
import com.rasmoo.client.raspay.repository.CustomerRepository;
import com.rasmoo.client.raspay.repository.OrderRepository;
import com.rasmoo.client.raspay.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final CreditCardRepository creditCardRepository;

    private final CustomerRepository customerRepository;

    private final OrderRepository orderRepository;

    @Autowired
    PaymentServiceImpl(CreditCardRepository creditCardRepository, CustomerRepository customerRepository,
                       OrderRepository orderRepository) {
        this.creditCardRepository = creditCardRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Boolean process(PaymentDto paymentDto) {

        if (orderRepository.findById(paymentDto.getOrderId()).isEmpty()) {
            throw new NotFoundException("Pedido não encontrado");
        }

        var customer = customerRepository.findById(paymentDto.getCustomerId());
        if (customer.isEmpty()) {
            throw new NotFoundException("Cliente não encontrado");
        }

        var ccList = creditCardRepository.findByNumber(paymentDto.getCreditCard().getNumber());
        CreditCardModel ccModel = CreditCardMapper.fromDtoToModel(paymentDto.getCreditCard(), paymentDto.getCustomerId());
        if (ccList.isEmpty()) {
            creditCardRepository.save(ccModel);
        } else {
            ccList.forEach(creditCardModel -> {
                if (!creditCardModel.getCustomerId().equals(paymentDto.getCustomerId()) &&
                        !creditCardModel.getDocumentNumber().equals(customer.get().getCpf())) {
                    throw new BusinessException("Pagamento negado pela processadora", HttpStatus.UNAUTHORIZED);
                } else if (!creditCardModel.getCustomerId().equals(paymentDto.getCustomerId()) &&
                        creditCardModel.getDocumentNumber().equals(customer.get().getCpf())) {
                    creditCardRepository.save(ccModel);
                }
            });

        }
        return true;
    }
}

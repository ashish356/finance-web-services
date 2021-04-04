package com.org.ashish.financewebservices.fixedDeposits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class FixedDepositResource
{
    @Autowired
    private FixedDepositService fixedDepositService;

    @GetMapping("/banks/fixedDeposits")
    public List<FixedDeposit> getAllFixedDeposits()
    {
      return  fixedDepositService.findAll();
    }

    @DeleteMapping("/banks/fixedDeposits/{id}")
    public ResponseEntity<Void> deleteFixedDeposits(@PathVariable long id)
    {
        FixedDeposit fixedDeposit = fixedDepositService.deleteById(id);
        if(fixedDeposit !=null)
        {
            return  ResponseEntity.noContent().build();
        }
        return  ResponseEntity.notFound().build();
    }

    @GetMapping("/banks/fixedDeposits/{id}")
    public FixedDeposit getFixedDeposit(@PathVariable long id)
    {
        return fixedDepositService.findById(id);
    }

    @PutMapping("/banks/fixedDeposits/{id}")
    public ResponseEntity<FixedDeposit> updateFixedDeposit(@PathVariable long id, @RequestBody FixedDeposit fixedDeposit)
    {
        FixedDeposit fixedDepositUpdated = fixedDepositService.save(fixedDeposit);
        return  new ResponseEntity<FixedDeposit>(fixedDeposit, HttpStatus.OK);
    }

    @PostMapping("/banks/fixedDeposits")
    public ResponseEntity<Void> updateFixedDeposit(@RequestBody FixedDeposit fixedDeposit)
    {
        FixedDeposit fixedDepositCreated= fixedDepositService.save(fixedDeposit);

        URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fixedDepositCreated.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}


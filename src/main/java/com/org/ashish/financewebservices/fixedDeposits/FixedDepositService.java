package com.org.ashish.financewebservices.fixedDeposits;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class FixedDepositService {

    private static List<FixedDeposit> fixedDepositList =new ArrayList<>();
    private static int idCounter=0;

    static {
        fixedDepositList.add(new FixedDeposit(++idCounter, "ICICI", 50000, 55000, new Date()));
        fixedDepositList.add(new FixedDeposit(++idCounter, "ICICI", 25000, 30000, new Date()));
        fixedDepositList.add(new FixedDeposit(++idCounter, "ICICI", 30000, 35000, new Date()));
        fixedDepositList.add(new FixedDeposit(++idCounter, "HDFC", 50000, 55000, new Date()));
        fixedDepositList.add(new FixedDeposit(++idCounter, "HDFC", 30000, 35000, new Date()));
        fixedDepositList.add(new FixedDeposit(++idCounter, "ICICI", 50000, 55000, new Date()));

    }


    public List<FixedDeposit> findAll()
    {
        return fixedDepositList;
    }

    public FixedDeposit save(FixedDeposit fixedDeposit)
    {
        if(fixedDeposit.getId()==-1|| fixedDeposit.getId()==0)
        {
            fixedDeposit.setId((long) ++idCounter);
        }else
        {
            deleteById(fixedDeposit.getId());
        }
        fixedDepositList.add(fixedDeposit);
        return fixedDeposit;
    }

    public FixedDeposit deleteById(long id)
    {
        FixedDeposit fixedDeposit =findById(id);
        if(fixedDeposit ==null)
        {
            return  null;
        }
        if(fixedDepositList.remove(fixedDeposit))
        {
            return fixedDeposit;
        }
        return  null;

    }

    public FixedDeposit findById(long id) {

        for(FixedDeposit fixedDeposit : fixedDepositList) {
            if (fixedDeposit.getId() == id) {
                return fixedDeposit;
            }
        }
        return  null;
    }

}

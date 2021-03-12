package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.AddressService;
import top.durandal.dao.AddressDao;
import top.durandal.entity.Address;

import javax.annotation.Resource;
import java.util.List;
@Service
@Component
public class AddressServiceImpl implements AddressService {

    @Resource
    AddressDao addressDao;

    public Address queryById(Integer addressId) {
        return null;
    }

    public List<Address> queryAllByLimit(int offset, int limit) {
        return null;
    }

    public Address insert(Address address) {
        int insert = addressDao.insert(address);
        if (insert!=0){
            return address;
        }
        return null;
    }

    public Address update(Address address) {
        Address hasAddress = addressDao.queryById(address.getAddressId());
        if (hasAddress==null){
            return null;
        }
        addressDao.update(address);
        return addressDao.queryById(address.getAddressId());
    }

    public boolean deleteById(Integer addressId) {
        return false;
    }

    public List<Address> getAddressByUserId(Integer userId) {
        List<Address> allAddress = addressDao.getAddressByUserId(userId);
        if (allAddress.size()!=0){
            return allAddress;
        }
        return null;
    }
}

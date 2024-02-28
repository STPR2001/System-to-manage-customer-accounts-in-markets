package logic.interfaces;

import java.util.ArrayList;
import logic.classes.Account;
import logic.classes.AccountUser;
import logic.classes.Organization;

public interface IOrganizationController {
    public abstract Organization getOrganizationByAccountId(String accountId);
    public abstract Organization getOrganizationByDebtTransactionId(String transactionId);
    public abstract ArrayList<AccountUser> getAccountAndUserDetails(String organizationId);
    public abstract Organization getOrganizationById(String id);
    public abstract ArrayList<Organization> listOrganiztions();
    public abstract ArrayList<Organization> getAllOrganizationsById(int ownerId);
    public abstract String getOrganizationDescriptionById(int orgId);
    public abstract void  createOrganizaation (String name, String description, boolean isPublic, String password, String city, String address);
    public abstract ArrayList<Organization> listAllOrganizations();
}

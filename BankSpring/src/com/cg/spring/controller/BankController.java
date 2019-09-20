package com.cg.spring.controller;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.spring.exception.BankBalanceException;
import com.cg.spring.exception.AccountCreateException;
import com.cg.spring.exception.BankException;
import com.cg.spring.model.Account;
import com.cg.spring.service.IBankService;

@Controller
public class BankController {

	@Autowired
	IBankService service;

	@RequestMapping("/home")
	public String addPage() {
		String view = "menu";
		return view;
	}

	@RequestMapping("/add")
	public String addAccountScreen(Model model) {
		String view = "addAccount";
		model.addAttribute("Account", new Account());
		return view;
	}

	@RequestMapping(value = "/accountAdded", method = RequestMethod.POST)
	public String AccountIdGenerator(Model model, @ModelAttribute("Account") Account account) {
		String view = "";
		try {
			int id = service.addAccount(account);
			model.addAttribute("accountId", id);
			view = "idGenerated";
		} catch (AccountCreateException e) {
			model.addAttribute("error", e.getMessage());
			view = "errorPage";
		}
		return view;
	}

	@RequestMapping("/deposit")
	public String depositScreen() {
		String view = "depositMoney";
		return view;
	}

	@RequestMapping(value = "/moneyDeposited", method = RequestMethod.POST)
	public String moneyDeposited(Model model, @RequestParam("accountId") int accountId,
			@RequestParam("money") int money) {
		String view = "";
		try {
			int accBalance = service.depositMoney(accountId, money);
			model.addAttribute("accountBalance", accBalance);
			view = "balanceScreen";
		} catch (BankException e) {
			model.addAttribute("error", e.getMessage());
			view = "errorPage";
		}
		return view;
	}

	@RequestMapping("/withdraw")
	public String withdrawScreen() {
		String view = "withdraw";
		return view;
	}

	@RequestMapping(value = "/moneyWithdrawed", method = RequestMethod.POST)
	public String moneyWithdrawed(Model model, @RequestParam("accountId") int accountId,
			@RequestParam("money") int money) {
		String view = "";
		try {
			int accBalance = service.withdrawMoney(accountId, money);
			model.addAttribute("accountBalance", accBalance);
			view = "balanceScreen";
		} catch (BankException e) {
			model.addAttribute("error", e.getMessage());
			view = "errorPage";
		} catch (BankBalanceException e) {
			model.addAttribute("error", e.getMessage());
			view = "errorPage";
		}
		return view;
	}

	@RequestMapping("/transfer")
	public String transferScreen() {
		String view = "fundTransfer";
		return view;
	}

	@RequestMapping(value = "/fundTransfer", method = RequestMethod.POST)
	public String transferMoney(Model model, @RequestParam("accountId") int accountId,
			@RequestParam("receiverAccountId") int receiverId, @RequestParam("money") int money) {
		String view = "";
		try {
			String transfer = service.fundTransfer(accountId, receiverId, money);
			model.addAttribute("transferMessage", transfer);
			view = "success";
		} catch (BankException e) {
			model.addAttribute("error", e.getMessage());
			view = "errorPage";
		} catch (BankBalanceException e) {
			model.addAttribute("error", e.getMessage());
			view = "errorPage";
		}
		return view;
	}

	@RequestMapping("/balance")
	public String showBalanceScreen() {
		String view = "showBalance";
		return view;
	}

	@RequestMapping(value = "/availableBalance", method = RequestMethod.POST)
	public String availableBalance(Model model, @RequestParam("accountId") int accountId) {
		String view = "showAvailableBalance";
		try {
			int balance = service.showBalance(accountId);
			model.addAttribute("balance", balance);
			view = "balanceValue";
		} catch (BankException e) {
			model.addAttribute("error", e.getMessage());
			view = "errorPage";
		}
		return view;
	}

	@RequestMapping("/details")
	public String showDetails() {
		String view = "showDetails";
		return view;
	}

	@RequestMapping("/availableDetails")
	public String availableDetails(Model model, @RequestParam("accountId") int accountId) {
		String view = "";
		try {
			Account acc = service.showDetails(accountId);
			model.addAttribute("accountDetails", acc);
			view = "userData";
		} catch (BankException e) {
			model.addAttribute("error", e.getMessage());
			view = "errorPage";
		}
		return view;
	}
}



